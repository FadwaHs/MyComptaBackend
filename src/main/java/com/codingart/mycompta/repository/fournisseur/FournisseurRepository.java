package com.codingart.mycompta.repository.fournisseur;
import com.codingart.mycompta.model.client.Client;
import com.codingart.mycompta.model.fournisseur.Fournisseur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface FournisseurRepository extends JpaRepository<Fournisseur, Long>{
    @Query(value = "select f from Fournisseur f left join f.address a left join f.motCleList m left join f.societe.address sa " +
            "where concat_ws('-',concat(f.firstName,' ',f.lastName),a.city,a.country,m.mot,sa.city,sa.country) like %?1%")
    Page<Fournisseur> findByDataContaining(String data, Pageable pageable);

  @Query(value = "select new com.codingart.mycompta.model.fournisseur.Fournisseur(f.id,f.firstName,f.lastName) from Fournisseur f")
   List<Fournisseur> selectAllByIdAndFirstNameAndLastName();

}
