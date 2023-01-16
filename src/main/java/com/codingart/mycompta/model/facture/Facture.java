package com.codingart.mycompta.model.facture;

import com.codingart.mycompta.model.article.Article;
import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.general_infos.MotCle;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_facture")
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "seq_facture")
    private Long id;
    private String CodeF;
    private String Devise;
    private String TextIntro;
    private String TextCond;
    private String piedPage;
    private String CondVente;

    @ColumnDefault("false")
    private boolean isFinalized;
    @ColumnDefault("false")
    private boolean isPayed;

//    @ElementCollection
//    private List<Character> Status;


//    Relation between Facture and MotCle
    @OneToMany(mappedBy = "facture",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<MotCle> motCleList;

//    Relation between Facture and Article
    @OneToMany(mappedBy = "facture",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Article> articleList;

//    Relation between Facture and Debours
    @OneToMany(mappedBy = "facture",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Debours> debours;

//    Relation between Facture and Devis
    @ManyToOne
    @JoinColumn(name = "devis_id")
    private Devis devis;

//    Self join Relation
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facture_id")
    private Facture parent;

    @OneToMany(mappedBy = "parent",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private List<Facture> children;

}
