package com.codingart.mycompta;

import com.codingart.mycompta.model.enums.DevisStatus;
import com.codingart.mycompta.model.client.Client;
import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.repository.client.ClientRepository;
import com.codingart.mycompta.repository.client.SocieteRepository;
import com.codingart.mycompta.repository.config.CompteBancRepository;
import com.codingart.mycompta.repository.devis.DevisRepository;
import com.codingart.mycompta.repository.environment.EnvironmentRepository;
import com.codingart.mycompta.repository.facture.FactureSimpleRepository;
import com.codingart.mycompta.repository.general_infos.AddressRepository;
import com.codingart.mycompta.repository.general_infos.PhoneRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class MyComptaApplication implements CommandLineRunner {
//
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods("GET", "POST", "DELETE", "PUT")
                        .maxAge(3600);
            }
        };
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


    @Autowired
    ClientRepository clientRepository;
    @Autowired
    PhoneRepository phoneRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    DevisRepository devisRepository;
    @Autowired
    CompteBancRepository compteBancRepository;
    @Autowired
    EnvironmentRepository environmentRepository;

    @Autowired
    FactureSimpleRepository factureSimpleRepository;



    @Autowired
    SocieteRepository societeRepository;


     static Client c = new Client();

    public static void main(String[] args) {
        SpringApplication.run(MyComptaApplication.class, args);
    }


    @Transactional
    @Override
    public void run(String... args) throws Exception {
//        this.test();

    }

    public void test(){
        // Add Devis

        Devis d1 = new Devis();
        Devis d2 = new Devis();
        Devis d3 = new Devis();
        Devis d4 = new Devis();
        d1.setCode("D1111");
        d2.setCode("D2222");
        d3.setCode("D3333");
        d4.setCode("D4444");
        d2.setStatus(DevisStatus.FINALIZED);
        d3.setStatus(DevisStatus.SIGNED);
        d4.setStatus(DevisStatus.REFUSED);
        devisRepository.save(d1);
        devisRepository.save(d2);
        devisRepository.save(d3);
        devisRepository.save(d4);
    }


}
