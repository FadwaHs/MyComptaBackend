package com.codingart.mycompta;

import com.codingart.mycompta.model.client.Client;
import com.codingart.mycompta.model.client.Societe;
import com.codingart.mycompta.model.config.CompteBanc;
import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.environment.Environment;
import com.codingart.mycompta.model.facture.FactureSimple;
import com.codingart.mycompta.model.general_infos.Address;
import com.codingart.mycompta.model.general_infos.Phone;
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

import java.util.*;


@SpringBootApplication
public class MyComptaApplication  implements CommandLineRunner{

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

//        List<Client> cpar= clientRepository.SelectAllClientPar();
//        List<Client> cpro= clientRepository.SelectAllClientPro();
//        System.out.println(cpar);
//        System.out.println(cpro);

        //add Societe
//        Societe s = new Societe();
//        s.setName("Coding Art");
//        s.setLanguage("Français");
//
//        Client c = new Client();
//        List<Client> listClient = new ArrayList<>();
//        c.setFirstName("Marwane");
//        c.setLastName("Bella");
//        c.setLanguage("Français");
//        listClient.add(c);
//        s.setClientList(listClient);
//        societeRepository.save(s);
        // add enviroment

        Environment parent = new Environment();
        parent.setName("Parent Environment");

        parent = environmentRepository.save(parent);

        Environment child1 = new Environment();
        child1.setName("Child Environment");
        child1.setDescription("workspace");

        child1.setParent(parent);

        Environment child2 = new Environment();
        child2.setName("Child Environment");
        child2.setDescription("workspace");

        child2.setParent(parent);

        environmentRepository.save(child2);

        environmentRepository.save(child1);
        


//        add facture simple

        FactureSimple f = new FactureSimple();
        f.setCodeF("F0794793");
        f.setDestined(true);

        factureSimpleRepository.save(f);



        // add client


        c.setFirstName("Marwane");
        c.setLastName("Bella");
        c.setEmail("bella@gmail.com");
        c.setLanguage("English");

        c = clientRepository.save(c);

        c = new Client();
        c.setFirstName("Hamza");
        c.setLastName("Ezzaki");
        c.setEmail("Hamza@gmail.com");
        c.setLanguage("Français");

        c = clientRepository.save(c);


        // add Note




        // add phone

        Phone p1 = new Phone();





        // add Address

        Address a = new Address();
        List<String> ca = new ArrayList<String>();
        ca.add("Hay chninate");
        ca.add("Hay Takadom");
        ca.add("Hay rtaym");
        a.setCity("houwara");
        a.setComplementAddress(ca);

        addressRepository.save(a);


        // add Devis

        Devis d = new Devis();
        d.setValidationDuration(new Date());

        devisRepository.save(d);

//        List<Character> status = new ArrayList<>();
//        status.add('p');
//        status.add(('d'));
//        d.setStatus(status);
//        Devis dd = devisRepository.save(d);
//        System.out.println(dd.getStatus());
//
//        dd.getStatus().remove(0);
//
//        System.out.println(dd.getStatus());
//
//
//        if(dd.getStatus().contains('p')){
//            System.out.println("isPayed");
//        }else{
//            System.out.println("IsNotPayed");
//        }

        //Add compte bancaire


        CompteBanc compteBanc = new CompteBanc();

        compteBanc.setBic("898");
        compteBanc.setIban("8778");
        compteBanc.setTitulaire("787");
        compteBanc.setLibelleCompte("0000");
        compteBancRepository.save(compteBanc);


//        CompletableFuture.delayedExecutor(5, TimeUnit.SECONDS).execute(() -> {
//
//        });

    }


}
