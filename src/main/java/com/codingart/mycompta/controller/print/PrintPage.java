package com.codingart.mycompta.controller.print;

import com.codingart.mycompta.dto.DevisDto;
import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.opportunite.Opportunite;
import com.codingart.mycompta.service.bon.BonCommandeService;
import com.codingart.mycompta.service.devis.DevisService;
import com.codingart.mycompta.service.devis.DevisServiceImpl;
import com.codingart.mycompta.service.opportunite.OpportuniteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PrintPage {
    @Autowired
    private  DevisService devisService;


    @GetMapping("/api/print/devis/{id}")
    public ModelAndView printDevis(@PathVariable("id") Long id)  {
        DevisDto devisDto = devisService.getDevis(id);
        ModelAndView modelAndView = new ModelAndView("Devis"); // This refers to the template file name "Devis.html"
        modelAndView.addObject("devis", devisDto);
        return modelAndView;
    }



}
