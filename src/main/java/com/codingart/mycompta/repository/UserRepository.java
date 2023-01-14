package com.codingart.mycompta.repository;

import com.codingart.mycompta.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}