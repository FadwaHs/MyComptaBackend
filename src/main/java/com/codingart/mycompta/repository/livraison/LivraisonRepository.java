package com.codingart.mycompta.repository.livraison;

import com.codingart.mycompta.model.livraison.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivraisonRepository extends JpaRepository<Livraison, Long> {
}
