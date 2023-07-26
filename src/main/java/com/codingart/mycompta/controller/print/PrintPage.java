package com.codingart.mycompta.controller.print;

import com.codingart.mycompta.dto.DevisDto;
import com.codingart.mycompta.model.client.Societe;
import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.facture.FactureAcompte;
import com.codingart.mycompta.model.facture.FactureAvoir;
import com.codingart.mycompta.model.facture.FactureSimple;
import com.codingart.mycompta.model.opportunite.Opportunite;
import com.codingart.mycompta.service.bon.BonCommandeService;
import com.codingart.mycompta.service.calcule.CalculeServiceImpl;
import com.codingart.mycompta.service.client.ClientService;
import com.codingart.mycompta.service.devis.DevisService;
import com.codingart.mycompta.service.devis.DevisServiceImpl;
import com.codingart.mycompta.service.facture.FactureAcompteService;
import com.codingart.mycompta.service.facture.FactureAvoirService;
import com.codingart.mycompta.service.facture.FactureSimpleService;
import com.codingart.mycompta.service.opportunite.OpportuniteService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.core.io.ClassPathResource;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.w3c.dom.Document;
import org.xhtmlrenderer.util.XRLog;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@Controller
@RequiredArgsConstructor
public class PrintPage {
    private final DevisService devisService;
    private final CalculeServiceImpl calculeService;
    private final TemplateEngine templateEngine;
    private final FactureSimpleService factureSimpleService;
   // private final SpringTemplateEngine templateEngine; // Inject the template engine

    private final FactureAcompteService factureAcompteService;
    private final ClientService clientService;
    private final FactureAvoirService factureAvoirService;
    Optional<Societe> societe = Optional.of(new Societe());



    @GetMapping("/api/print/devis/{id}")
    public String printDevis2(@PathVariable("id") Long id, Model model) {
        DevisDto devisDto = devisService.getDevis(id);
        model.addAttribute("devis", devisDto);
        model.addAttribute("calculeService", calculeService);
        return "Devis"; // Return the template name without processing it here
    }


    @GetMapping("/api/pdf/devis/{id}")
    public ResponseEntity<byte[]> generatePdfDevis(@PathVariable("id") Long id) throws Exception {
        DevisDto devisDto = devisService.getDevis(id);
        Context context = new Context();
        context.setVariable("devis", devisDto);
        context.setVariable("calculeService", calculeService);
        String renderedHtml = templateEngine.process("Devis", context);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ITextRenderer renderer = new ITextRenderer();

        // Set the base URL for resolving relative URLs
        URL baseUrl = new ClassPathResource("templates/Devis.html").getURL();
        renderer.setDocumentFromString(renderedHtml, baseUrl.toString());

        renderer.layout();
        renderer.createPDF(outputStream);
        renderer.finishPDF();

        // Set the filename to ${devis.code}.pdf
        String filename = devisDto.getCode() + ".pdf";

        // Convert ByteArrayOutputStream to byte[]
        byte[] pdfBytes = outputStream.toByteArray();

        // Set the response headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("inline", filename);

        // Return the PDF content as ResponseEntity
        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }

    @GetMapping("/api/print/factureSimple/{id}")
    public String printFactureS(@PathVariable("id") Long id, Model model) {
        FactureSimple facture = factureSimpleService.getFactureSimple(id);
        if(facture.getClient()!=null){
            societe= clientService.getSocieteByClientId(facture.getClient().getId());
            if(societe!=null)
                model.addAttribute("societe", societe);
        }
        model.addAttribute("facture", facture);
        model.addAttribute("calculeService", calculeService);
        return "FactureSimple"; // Return the template name without processing it here
    }
    @GetMapping("/api/pdf/factureSimple/{id}")
    public ResponseEntity<byte[]> generatePdfFactureS(@PathVariable("id") Long id) throws Exception {
        FactureSimple facture = factureSimpleService.getFactureSimple(id);

        Context context = new Context();
        context.setVariable("facture", facture);
        context.setVariable("calculeService", calculeService);
        String renderedHtml = templateEngine.process("FactureSimple", context);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ITextRenderer renderer = new ITextRenderer();

        // Set the base URL for resolving relative URLs
        URL baseUrl = new ClassPathResource("templates/FactureSimple.html").getURL();
        renderer.setDocumentFromString(renderedHtml, baseUrl.toString());

        renderer.layout();
        renderer.createPDF(outputStream);
        renderer.finishPDF();

        // Set the filename to ${devis.code}.pdf
        String filename = facture.getCode() + ".pdf";

        // Convert ByteArrayOutputStream to byte[]
        byte[] pdfBytes = outputStream.toByteArray();

        // Set the response headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("inline", filename);

        // Return the PDF content as ResponseEntity
        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }



    @GetMapping("/api/print/factureAvoir/{id}")
    public String printFactureAv(@PathVariable("id") Long id, Model model) {
        FactureAvoir facture = factureAvoirService.getFactureAvoir(id);
        model.addAttribute("facture", facture);
        model.addAttribute("calculeService", calculeService);
        return "FactureAvoir"; // Return the template name without processing it here
    }

    @GetMapping("/api/pdf/factureAvoir/{id}")

        public ResponseEntity<byte[]>  generatePdfFactureAv(@PathVariable("id") Long id) throws Exception {
        FactureAvoir facture = factureAvoirService.getFactureAvoir(id);

        Context context = new Context();
        context.setVariable("facture", facture);
        context.setVariable("calculeService", calculeService);
        String renderedHtml = templateEngine.process("FactureSimple", context);



        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ITextRenderer renderer = new ITextRenderer();

        // Set the base URL for resolving relative URLs
        URL baseUrl = new ClassPathResource("templates/FactureAvoir.html").getURL();
        renderer.setDocumentFromString(renderedHtml, baseUrl.toString());

        renderer.layout();
        renderer.createPDF(outputStream);
        renderer.finishPDF();


        // Set the filename to ${devis.code}.pdf
        String filename = facture.getCode() + ".pdf";

        // Convert ByteArrayOutputStream to byte[]
        byte[] pdfBytes = outputStream.toByteArray();

        // Set the response headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("inline", filename);

        // Return the PDF content as ResponseEntity
        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }
    @GetMapping("/api/print/factureAcompte/{id}")
    public String printFactureA(@PathVariable("id") Long id, Model model) {
        FactureAcompte facture = factureAcompteService.getFactureAcompte(id);
        Devis devis= facture.getDevis();
        if(devis.getClient()!=null){
            societe= clientService.getSocieteByClientId(devis.getClient().getId());
            if(societe!=null)
                model.addAttribute("societe", societe);
        }
        model.addAttribute("devis", devis);
        model.addAttribute("facture", facture);
        model.addAttribute("calculeService", calculeService);
        return "FactureAcompte"; // Return the template name without processing it here
    }
    
    @GetMapping("/api/pdf/factureAcompte/{id}")
    public ResponseEntity<byte[]> generatePdfFactureA(@PathVariable("id") Long id) throws Exception {
        FactureAcompte facture = factureAcompteService.getFactureAcompte(id);

        Context context = new Context();
        context.setVariable("facture", facture);
        context.setVariable("calculeService", calculeService);
        String renderedHtml = templateEngine.process("FactureAcompte", context);



        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ITextRenderer renderer = new ITextRenderer();

        // Set the base URL for resolving relative URLs
        URL baseUrl = new ClassPathResource("templates/FactureAcompte.html").getURL();
        renderer.setDocumentFromString(renderedHtml, baseUrl.toString());

        renderer.layout();
        renderer.createPDF(outputStream);
        renderer.finishPDF();


        // Set the filename to ${devis.code}.pdf
        String filename = facture.getCode() + ".pdf";

        // Convert ByteArrayOutputStream to byte[]
        byte[] pdfBytes = outputStream.toByteArray();

        // Set the response headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("inline", filename);

        // Return the PDF content as ResponseEntity
        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }




}