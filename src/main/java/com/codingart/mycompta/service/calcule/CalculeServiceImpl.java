package com.codingart.mycompta.service.calcule;

import com.codingart.mycompta.model.article.Article;
import com.codingart.mycompta.model.devis.Devis;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CalculeServiceImpl {




    public double calculht(Article article) {


        double total = 0;
        total = article.getPrixHT() * article.getQuantity();
        if (article.getReduction() != 0) {

            if (!article.isRedIsPercentage()) {
                total = (article.getPrixHT() * article.getQuantity()) - article.getReduction();
            }else total=(article.getPrixHT() * article.getQuantity()) *(1- article.getReduction()/100);

        }
        return total;
    }


    public double calculateTotalttc(Article article) {


        double totalTTC = 0;
        totalTTC = article.getPrixHT() * article.getQuantity();
        if (article.getReduction() != 0) {
            if (!article.isRedIsPercentage()) {
                totalTTC = (totalTTC -  article.getReduction()) * (1 + (article.getTva()/100));
            }else totalTTC= totalTTC * (1 - article.getReduction()/100) *(1- (article.getTva()/100));
        }else totalTTC = totalTTC * (1 +(article.getTva()/100));
        return totalTTC;
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

    public String reduction(Devis devis) {
        if (devis == null) {
            return "";
        }
        if (devis.isRemIsPercentage()) {
            return "%";
        }
        return devise(devis.getDevise());
    }


}
