package com.codingart.mycompta.service.calcule;

import com.codingart.mycompta.model.article.Article;
import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.facture.Facture;
import com.codingart.mycompta.model.facture.FactureAcompte;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CalculeServiceImpl {




    public double calculht(Article article) {

        double totalArticleHT = article.getPrixHT() * article.getQuantity();
        if (article.getReduction() != 0) {
            if (!article.isRedIsPercentage()) {
                totalArticleHT -= article.getReduction();
            } else {
                totalArticleHT *= (1 - article.getReduction() / 100);
            }
        }
        return totalArticleHT;

    }


    public double calculateTotalttc(Article article) {


        double totalArticleTTC = article.getPrixHT() * article.getQuantity();
        if (article.getReduction() != 0) {
            if (!article.isRedIsPercentage()) {
                totalArticleTTC -= article.getReduction();
            } else {
                totalArticleTTC *= (1 - article.getReduction() / 100);
            }
        }
        totalArticleTTC *= (1 + article.getTva() / 100);
        return totalArticleTTC;
    }

    public double calculetva ( Article article){
        return   calculateTotalttc(article) - calculht(article);
    }



    public String devise(String currency) {
        String regex = "\\(([^)]+)\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(currency);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return "";
        }
    }



    public String reduction(String devise, boolean remIsPercentage) {
        if (remIsPercentage) {
            return "%";
        }
        return devise(devise);
    }

    public String calclulTVAPer(Facture facture) {
        double montantTVA = facture.getTotalTTC() - facture.getTotalHT();
        double pourcentageTVA = (montantTVA * 100) / facture.getTotalHT();
        return pourcentageTVA+"%";
    }

    public String calculMontant(FactureAcompte facture, double montant) {
        double pourcentage;
        if (facture.isMonIsPercentage()) {
            pourcentage = facture.getMontantPayed();
        } else {
            pourcentage = (facture.getMontantPayed() * 100) / montant;
        }

        // Arrondir le pourcentage à deux décimales
        String pourcentageArrondi = String.format("%.2f", pourcentage);

        return pourcentageArrondi + " %";
    }
}