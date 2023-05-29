package com.codingart.mycompta.model.opportunite;


import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.general_infos.MotCle;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
//lombock
@Getter
@Setter
@Validated
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
public class Pipeline {

    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    //+
    @Column(unique = true)
    private String slug;
    //+
    @JsonBackReference("pipeline_etape")
    //@JsonManagedReference
    @OneToMany(mappedBy = "pipeline",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Etape> etapeList;

    @PostLoad
    public void initializeListEtape() {

        if (this.etapeList == null) {
            this.etapeList = new ArrayList<>();
        } else {
            // remove duplicates
            Set<Etape> uniqueEtape = new HashSet<>(this.etapeList);
            this.etapeList.clear();
            this.etapeList.addAll(uniqueEtape);
        }
    }

    @PrePersist
    public void setDataPrePersist(){
        this.slug = RandomStringUtils.randomAlphanumeric(10).toLowerCase();
    }


}
