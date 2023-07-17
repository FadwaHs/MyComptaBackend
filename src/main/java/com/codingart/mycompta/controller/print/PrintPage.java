package com.codingart.mycompta.controller.print;

import com.codingart.mycompta.dto.DevisDto;
import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.opportunite.Opportunite;
import com.codingart.mycompta.service.bon.BonCommandeService;
import com.codingart.mycompta.service.devis.DevisService;
import com.codingart.mycompta.service.devis.DevisServiceImpl;
import com.codingart.mycompta.service.opportunite.OpportuniteService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

@Controller
public class PrintPage {
    @Autowired
    private  DevisService devisService;
    @Autowired
    private TemplateEngine templateEngine;

    @GetMapping("/api/print/devis/{id}")
    public ModelAndView printDevis(@PathVariable("id") Long id)  {
        DevisDto devisDto = devisService.getDevis(id);
        ModelAndView modelAndView = new ModelAndView("Devis"); // This refers to the template file name "Devis.html"
        modelAndView.addObject("devis", devisDto);
        return modelAndView;
    }

    @GetMapping("/api/pdf/devis/{id}")
    public void generatePdfDevis(@PathVariable("id") Long id, HttpServletResponse response) throws Exception {
        DevisDto devisDto = devisService.getDevis(id);

        Context context = new Context();
        context.setVariable("devis", devisDto);

        String renderedHtml = templateEngine.process("Devis", context); // This refers to the template file name "Devis.html"

        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(renderedHtml);
        renderer.layout();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        renderer.createPDF(outputStream);
        renderer.finishPDF();

        // Set the response headers
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline; filename=devis.pdf");

        // Write the PDF content to the response OutputStream
        OutputStream outStream = response.getOutputStream();
        outputStream.writeTo(outStream);
        outStream.flush();
    }

}
