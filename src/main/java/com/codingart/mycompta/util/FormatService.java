package com.codingart.mycompta.util;

import com.codingart.mycompta.enums.ResetCounter;
import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.config.Numerotation;
import com.codingart.mycompta.repository.config.NumerotationRepository;
import com.codingart.mycompta.repository.devis.DevisRepository;
import com.codingart.mycompta.repository.facture.FactureAcompteRepository;
import com.codingart.mycompta.repository.facture.FactureAvoirRepository;
import com.codingart.mycompta.repository.facture.FactureSimpleRepository;
import com.codingart.mycompta.service.facture.FactureSimpleService;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class FormatService {
    private final NumerotationRepository numerotationRepository;
    private final DevisRepository devisRepository;
    private final FactureSimpleRepository factureSimpleRepository;
    private final FactureAvoirRepository factureAvoirRepository;
    private final FactureAcompteRepository factureAcompteRepository;


    public Map<String,Object> createFormat(Date date, String from){
        Numerotation numerotation = this.numerotationRepository.findById(1L).orElseThrow(() -> new ResourceNotFoundException("Numerotation not exist by this id : "+1));
        String format = numerotation.getFormat();
        int minCounterSize = numerotation.getMinCounterSize();
        Long nextCmp = getNextCmp(from,numerotation.getResetCounter(),date);
        String cmpStr = String.format("%0"+minCounterSize+"d" , nextCmp );

        format = getNextFormat(format , date, from,cmpStr);
        Map<String,Object> mapData = new HashMap<>();
        mapData.put("format",format);
        mapData.put("cmp",nextCmp);

        return mapData;
    }

    private String getNextFormat(String format , Date date, String from,String cmpStr){
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        format = format.replaceAll("<cmp>",cmpStr);
        format = format.replaceAll("<doc>", from);
        format = format.replaceAll("<aaaa>",localDate.format(DateTimeFormatter.ofPattern("yyyy")));
        format = format.replaceAll("<aa>",localDate.format(DateTimeFormatter.ofPattern("yy")));
        format = format.replaceAll("<mm>",localDate.format(DateTimeFormatter.ofPattern("MM")));
        format = format.replaceAll("<m>",localDate.format(DateTimeFormatter.ofPattern("M")));
        format = format.replaceAll("<jj>",localDate.format(DateTimeFormatter.ofPattern("dd")));
        format = format.replaceAll("<j>",localDate.format(DateTimeFormatter.ofPattern("d")));
        Pattern regrex = Pattern.compile("<[a-zA-Z0-9]+\\|[a-zA-Z0-9]+\\|[a-zA-Z0-9]+\\|[a-zA-Z0-9]+>");
        Matcher matcher = regrex.matcher(format);
        String customDoc;
        String[] customDocArray ;
        String specifyDoc = "";
        while (matcher.find()) {
            customDoc = matcher.group();
            customDoc  = customDoc.replaceAll(".*<|>.*","");
            customDocArray = customDoc.split("\\|");
            if(from.equals("F")) specifyDoc = customDocArray[0];
            if(from.equals("D")) specifyDoc = customDocArray[1];
            if(from.equals("A")) specifyDoc = customDocArray[2];
            if(from.equals("FA")) specifyDoc = customDocArray[3];
            format = format.replace(matcher.group(),specifyDoc);
        }

        return format;
    }
    
    
    private Long getNextCmp(String from,ResetCounter resetCounter,Date date){
        Long lastCmp = null;
        if(resetCounter == ResetCounter.YEAR) {
            switch (from) {
                case "D" -> lastCmp = this.devisRepository.selectLastCmpInYear(date);
                case "F" -> lastCmp = this.factureSimpleRepository.selectLastCmpInYear(date);
                case "A" -> lastCmp = this.factureAvoirRepository.selectLastCmpInYear(date);
                case "FA" -> lastCmp = this.factureAcompteRepository.selectLastCmpInYear(date);
            }
        } else if(resetCounter == ResetCounter.MONTH) {
            switch (from) {
                case "D" -> lastCmp = this.devisRepository.selectLastCmpInMonth(date);
                case "F" -> lastCmp = this.factureSimpleRepository.selectLastCmpInMonth(date);
                case "A" -> lastCmp = this.factureAvoirRepository.selectLastCmpInMonth(date);
                case "FA" -> lastCmp = this.factureAcompteRepository.selectLastCmpInMonth(date);
            }
        }else{
            switch (from) {
                case "D" -> lastCmp = this.devisRepository.selectLastCmp(date);
                case "F" -> lastCmp = this.factureSimpleRepository.selectLastCmp(date);
                case "A" -> lastCmp = this.factureAvoirRepository.selectLastCmp(date);
                case "FA" -> lastCmp = this.factureAcompteRepository.selectLastCmp(date);
            }
        }
        
        if(lastCmp != null ) return lastCmp + 1;
        else return 1L;

    }
    
    
}
