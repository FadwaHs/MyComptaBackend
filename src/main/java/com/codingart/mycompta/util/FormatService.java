package com.codingart.mycompta.util;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.config.Numerotation;
import com.codingart.mycompta.repository.config.NumerotationRepository;
import com.codingart.mycompta.repository.devis.DevisRepository;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@NoArgsConstructor
public class FormatService {
    @Autowired
    NumerotationRepository numerotationRepository;
    @Autowired
    DevisRepository devisRepository;

    public String createFormat(Date date, String from){
        Numerotation numerotation = this.numerotationRepository.findById(1L).orElseThrow(() -> new ResourceNotFoundException("Numerotation not exist by this id : "+1));
//        String format = numerotation.getFormat();

        System.out.println(devisRepository.selectLastIdDevisInYear(date));

        String format = "<doc>-<aaaa>/<mm>/<jj>-<cmp>   <fac|dev|avo|aco>-<aa>/<m>/<j>-<cmp><fac|dev|avo|aco>";
        int minCounterSize = numerotation.getMinCounterSize();
        String cmp = String.format("%014d" , 1 );


        System.out.println(cmp);

        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        format = format.replaceAll("<cmp>",cmp);
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


        System.out.println(format);
        return "";
    }
}
