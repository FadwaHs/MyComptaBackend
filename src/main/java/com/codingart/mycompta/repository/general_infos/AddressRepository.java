package com.codingart.mycompta.repository.general_infos;

import com.codingart.mycompta.model.general_infos.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}