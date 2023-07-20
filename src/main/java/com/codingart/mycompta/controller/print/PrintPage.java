package com.codingart.mycompta.controller.print;

import com.codingart.mycompta.dto.DevisDto;
import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.opportunite.Opportunite;
import com.codingart.mycompta.service.bon.BonCommandeService;
import com.codingart.mycompta.service.calcule.CalculeServiceImpl;
import com.codingart.mycompta.service.devis.DevisService;
import com.codingart.mycompta.service.devis.DevisServiceImpl;
import com.codingart.mycompta.service.opportunite.OpportuniteService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequiredArgsConstructor
public class PrintPage {
    private final DevisService devisService;
    private final CalculeServiceImpl calculeService;
   private final TemplateEngine templateEngine;
   // private final SpringTemplateEngine templateEngine; // Inject the template engine




 /*   @GetMapping("/api/print/devis/{id}")
    public ModelAndView printDevis2(@PathVariable("id") Long id)  {
        DevisDto devisDto = devisService.getDevis(id);
        ModelAndView modelAndView = new ModelAndView("Devis"); // This refers to the template file name "Devis.html"
        modelAndView.addObject("devis", devisDto);
        modelAndView.addObject("calculeService", calculeService);

        return modelAndView;
    }
*/
/*
    @GetMapping("/api/print/devis/{id}")
    public String printDevis2(@PathVariable("id") Long id) {
        DevisDto devisDto = devisService.getDevis(id);
        Context context = new Context();
        context.setVariable("devis", devisDto);
        context.setVariable("calculeService", calculeService);

        return templateEngine.process("Devis", context);
    }


    @GetMapping("/api/pdf/devis/{id}")
    public void generatePdfDevis(@PathVariable("id") Long id, HttpServletResponse response) throws Exception {
        String renderedHtml = printDevis2(id);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(renderedHtml);
        renderer.layout();
        renderer.createPDF(outputStream);
        renderer.finishPDF();

        // Set the response headers
        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        response.setHeader("Content-Disposition", "inline; filename=devis.pdf");

        // Write the PDF content to the response OutputStream
        OutputStream outStream = response.getOutputStream();
        outputStream.writeTo(outStream);
        outStream.flush();
    }

*/


    @GetMapping("/api/print/devis/{id}")
    public String printDevis2(@PathVariable("id") Long id, Model model) {
        DevisDto devisDto = devisService.getDevis(id);
        model.addAttribute("devis", devisDto);
        model.addAttribute("calculeService", calculeService);
        return "Devis"; // Return the template name without processing it here
    }

    @GetMapping("/api/pdf/devis/{id}")
    public void generatePdfDevis(@PathVariable("id") Long id, HttpServletResponse response) throws Exception {
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

        // Set the response headers
        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        response.setHeader("Content-Disposition", "inline; filename=devis.pdf");

        // Write the PDF content to the response OutputStream
        OutputStream outStream = response.getOutputStream();
        outputStream.writeTo(outStream);
        outStream.flush();
    }
}