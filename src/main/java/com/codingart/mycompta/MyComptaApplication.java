package com.codingart.mycompta;

import com.codingart.mycompta.enums.DevisStatus;
import com.codingart.mycompta.enums.FactureAcompteStatus;
import com.codingart.mycompta.model.article.Article;
import com.codingart.mycompta.model.article.TypeArticle;
import com.codingart.mycompta.model.client.Client;
import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.facture.FactureAcompte;
import com.codingart.mycompta.repository.article.ArticleRepository;
import com.codingart.mycompta.repository.article.TypeArticleRepository;
import com.codingart.mycompta.repository.client.ClientRepository;
import com.codingart.mycompta.repository.client.SocieteRepository;
import com.codingart.mycompta.repository.config.CompteBancRepository;
import com.codingart.mycompta.repository.devis.DevisRepository;
import com.codingart.mycompta.repository.environment.EnvironmentRepository;
import com.codingart.mycompta.repository.facture.FactureAcompteRepository;
import com.codingart.mycompta.repository.facture.FactureSimpleRepository;
import com.codingart.mycompta.repository.general_infos.AddressRepository;
import com.codingart.mycompta.repository.general_infos.PhoneRepository;
import com.codingart.mycompta.service.facture.FactureAcompteService;
import com.codingart.mycompta.service.facture.FactureSimpleService;
import com.codingart.mycompta.util.FormatService;
import lombok.Builder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Date;


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

    @Autowired
    FactureSimpleService factureSimpleService;

    @Autowired
    FactureAcompteService factureAcompteService;


     static Client c = new Client();
    @Autowired
    private TypeArticleRepository typeArticleRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private FormatService formatService;
    @Autowired
    private FactureAcompteRepository factureAcompteRepository;


    public static void main(String[] args) {
        SpringApplication.run(MyComptaApplication.class, args);
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
//        this.formatService.createFormat(new Date(),"D");
        this.test();
        testFacture();
    }

    public void testFacture(){
        Client c = new Client();
        c.setFirstName("Marwane");
        c.setLastName("Bella");
        c.setLanguage("fr");
        c = clientRepository.save(c);

        Devis d  = Devis.builder().id(1L).code("D23-0001").status(DevisStatus.FINALIZED).cmp(1L).client(c).build();
        d = devisRepository.save(d);
        FactureAcompte fa = FactureAcompte.builder().montantPayed(500).status(FactureAcompteStatus.PAYED).build();
        fa.setCode("FA23-0003");
        fa.setId(1L);
        fa.setDevis(d);
        factureAcompteService.addFactureAcompte(fa);
    }

    public void test(){

         //add Article
        Article a = new Article();
        TypeArticle t = new TypeArticle();
        a.setDescription("dell");

         t = typeArticleRepository.findById(1L).orElseThrow();
        a.setTypeArticle(t);
        a.setQuantity(3);
        a.setPrixHT(10);
        articleRepository.save(a);
//         Add Devis
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
