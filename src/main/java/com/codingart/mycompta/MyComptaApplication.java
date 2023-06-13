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
    private CompteBancRepository compteBancRepository;
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
        // this.formatService.createFormat(new Date(),"D");
       // this.test();
        //testFacture();

       /* Fournisseur fournisseur = new Fournisseur();
        fournisseur= fournisseurRepository.findById(2L).orElseThrow();

       List<AvoireFournisseur> avoirFournisseurList = fournisseur.getAvoirFournisseurList();
        List<SimpleFournisseur> simpleFournisseurList = fournisseur.getSimpleFournisseurList();

        System.out.println("Avoir Fournisseur List:");
        for (AvoireFournisseur avoirFournisseur : avoirFournisseurList) {
            System.out.println(avoirFournisseur.getId() + " " + avoirFournisseur.getStatus());
        }

        System.out.println("Simple Fournisseur List:");
        for (SimpleFournisseur simpleFournisseur : simpleFournisseurList) {
            System.out.println(simpleFournisseur.getId() + " " + simpleFournisseur.getStatus());
        };*/


       /* SimpleFournisseur simpleFournisseur = new SimpleFournisseur();
        simpleFournisseur = simpleFournisseurRepository.findById(1L).orElseThrow();

        AvoireFournisseur avoireFournisseur = new AvoireFournisseur();
        avoireFournisseur = avoirFournisseurRepository.findById(2L).orElseThrow();

        CompteBanc compteBanc = new CompteBanc();
        compteBanc = compteBancRepository.findById(1L).orElseThrow();

        Paiement paiement2 = new Paiement();
        paiement2.setType("Credit");
        paiement2.setMontant(1000.0);
        paiement2.setReference("REF126");
        paiement2.setDateReglement(new Date());
        paiement2.setDateRemise(new Date());
        paiement2.setFactureFournisseur(avoireFournisseur);
        paiement2.setCompteCrediteur(compteBanc);

        paiement2 = paiementRepository.save(paiement2);*/

       /* Address address = new Address();
        address = addressRepository.findById(6L).orElseThrow();

        Livraison deliveryInfo = new Livraison();
        deliveryInfo.setAdresseLivraison(address);
        deliveryInfo.setNombreColis(2);
        deliveryInfo.setPoidsTotal(5.2);
        deliveryInfo.setVolume(0.3);
        deliveryInfo.setNumeroSuivi("1234567890");
        deliveryInfo.setUrlSuivi("https://example.com/suivi");

        livraisonRepository.save(deliveryInfo);

        Fournisseur fournisseur1 = new Fournisseur();
        fournisseur1= fournisseurRepository.findById(1L).orElseThrow();

        BonsCommande bonCommande = new BonsCommande();
        bonCommande.setDevise("EUR");
        bonCommande.setTotalHT(100.0);
        bonCommande.setTotalTTC(120.0);
        bonCommande.setRemise(10.0);
        bonCommande.setDate_Livraison(new Date());
        bonCommande.setFournisseur(fournisseur1);

        bonCommande.setLivraison(deliveryInfo);

        bonCommandeRepository.save(bonCommande);

        BonLivraison bonLivraison = new BonLivraison();
        bonLivraison.setDevise("EUR");
        bonLivraison.setTotalHT(10.0);
        bonLivraison.setTotalTTC(190.0);
        bonLivraison.setRemise(10.0);
        bonLivraison.setFournisseur(fournisseur1);

        bonLivraisonRepository.save(bonLivraison); */


    }

    public void testFacture(){

        Fournisseur fournisseur = new Fournisseur();
        fournisseur= fournisseurRepository.findById(2L).orElseThrow();

       /* fournisseur.setFirstName("John2");
        fournisseur.setLastName("Doe2");
        fournisseur.setEmail("john2.doe@example.com");
        fournisseur.setFunction("Manager");
        fournisseur.setWebsite("https://example.com");
        fournisseur.setNote("Some notes about this fournisseur");
        fournisseur = fournisseurRepository.save(fournisseur);*/

        /*Client c = new Client();
        c.setFirstName("Marwane");
        c.setLastName("Bella");
        c.setLanguage("fr");
        c = clientRepository.save(c);

        Devis d  = Devis.builder().id(1L).code("D23-0001").status(DevisStatus.FINALIZED).cmp(1L).client(c).build();
        d = devisRepository.save(d);*/

        Article a2 = new Article();
        TypeArticle t = new TypeArticle();
        a2.setDescription("dell2");

        t = typeArticleRepository.findById(1L).orElseThrow();
        a2.setTypeArticle(t);
        a2.setQuantity(8);
        a2.setPrixHT(19);

       AvoireFournisseur avoireFournisseur = new AvoireFournisseur();
        avoireFournisseur.setFournisseur(fournisseur);
        avoireFournisseur.setDevise("EUR");
        avoireFournisseur.setStatus(AvoireFournisseurStatus.PROVISIONAL);

        a2.setAvoireFournisseur(avoireFournisseur);

        avoirFournisseurRepository.save(avoireFournisseur);

        articleRepository.save(a2);
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
    }




}
