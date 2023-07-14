package com.codingart.mycompta.configuration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Controller
public class WebController implements WebMvcConfigurer {
   // @RequestMapping(value = "/welcome", method = RequestMethod.GET)
   // public String index() {
      //  return "welcome";
  //  }

    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("devis");
    }
}