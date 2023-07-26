package com.codingart.mycompta;

import com.codingart.mycompta.enums.AvoireFournisseurStatus;
import com.codingart.mycompta.enums.DevisStatus;
import com.codingart.mycompta.enums.FactureAcompteStatus;
import com.codingart.mycompta.enums.SimpleFournisseurStatus;
import com.codingart.mycompta.model.article.Article;
import com.codingart.mycompta.model.article.TypeArticle;
import com.codingart.mycompta.model.bon.BonLivraison;
import com.codingart.mycompta.model.bon.BonsCommande;
import com.codingart.mycompta.model.client.Client;
import com.codingart.mycompta.model.config.CompteBanc;
import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.facture.FactureAcompte;
import com.codingart.mycompta.model.facturefournisseur.AvoireFournisseur;
import com.codingart.mycompta.model.facturefournisseur.FactureFournisseur;
import com.codingart.mycompta.model.facturefournisseur.Paiement;
import com.codingart.mycompta.model.facturefournisseur.SimpleFournisseur;
import com.codingart.mycompta.model.fournisseur.Fournisseur;
import com.codingart.mycompta.model.general_infos.Address;
import com.codingart.mycompta.model.livraison.Livraison;
import com.codingart.mycompta.repository.article.ArticleRepository;
import com.codingart.mycompta.repository.article.TypeArticleRepository;
import com.codingart.mycompta.repository.bon.BonCommandeRepository;
import com.codingart.mycompta.repository.bon.BonLivraisonRepository;
import com.codingart.mycompta.repository.client.ClientRepository;
import com.codingart.mycompta.repository.client.SocieteRepository;
import com.codingart.mycompta.repository.config.CompteBancRepository;
import com.codingart.mycompta.repository.devis.DevisRepository;
import com.codingart.mycompta.repository.environment.EnvironmentRepository;
import com.codingart.mycompta.repository.facture.FactureAcompteRepository;
import com.codingart.mycompta.repository.facture.FactureSimpleRepository;
import com.codingart.mycompta.repository.facturefournisseur.AvoirFournisseurRepository;
import com.codingart.mycompta.repository.facturefournisseur.PaiementRepository;
import com.codingart.mycompta.repository.facturefournisseur.SimpleFournisseurRepository;
import com.codingart.mycompta.repository.fournisseur.FournisseurRepository;
import com.codingart.mycompta.repository.general_infos.AddressRepository;
import com.codingart.mycompta.repository.general_infos.PhoneRepository;
import com.codingart.mycompta.repository.livraison.LivraisonRepository;
import com.codingart.mycompta.service.auth.AccountService;
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
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;


@SpringBootApplication
public class MyComptaApplication implements CommandLineRunner {

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

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("classpath:/templates/");
        templateResolver.setCharacterEncoding(StandardCharsets.UTF_8.name()); // Add this line to set character encoding

        templateResolver.setSuffix(".html");
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }

    @Bean
    public ViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        return viewResolver;
    }



    @Autowired
    ClientRepository clientRepository;
    @Autowired
    FournisseurRepository fournisseurRepository;

    @Autowired
    SimpleFournisseurRepository simpleFournisseurRepository;
    @Autowired
    AvoirFournisseurRepository avoirFournisseurRepository;

    @Autowired
    BonCommandeRepository bonCommandeRepository;

    @Autowired
    BonLivraisonRepository bonLivraisonRepository;

    @Autowired
    LivraisonRepository livraisonRepository;

    @Autowired
    AddressRepository addressRepository;


    @Autowired
    PaiementRepository paiementRepository;
    @Autowired
    PhoneRepository phoneRepository;
    @Autowired
    DevisRepository devisRepository;
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

        /* accountService.AddNewRole("Admin");
         accountService.AddNewRole("Manager");
         accountService.AddNewRole("Commercial");
         accountService.AddNewRole("Collaborateur");
         accountService.AddNewRole("Expert");

         accountService.AddNewUser("User1", "12345","User@gmail.com","12345");
         accountService.AddNewUser("admin", "12345","Admin@gmail.com","12345");

         accountService.addRoletoUser("User1","Commercial");
         accountService.addRoletoUser("admin","Admin"); */

    }







}
