package com.codingart.mycompta.repository.auth;

import com.codingart.mycompta.model.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    User findByEmail(String email);
}