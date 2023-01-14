package com.codingart.mycompta.repository;

import com.codingart.mycompta.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}