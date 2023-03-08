package com.codingart.mycompta.model.config;

import com.codingart.mycompta.model.devis.ConditionReglement;
import com.codingart.mycompta.model.facture.FactureSimple;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

//@JsonIdentityInfo(scope = ConfigAvoir.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
public class ConfigAvoir extends ConfigPreference{

}
