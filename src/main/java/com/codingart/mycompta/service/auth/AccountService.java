package com.codingart.mycompta.service.auth;

import com.codingart.mycompta.model.auth.Role;
import com.codingart.mycompta.model.auth.User;

public interface AccountService {

    User AddNewUser(String username, String password , String email , String confirmPassword);
    Role AddNewRole(String roleName);
    void addRoletoUser(String username, String roleName);
    void removeRoleFromUser(String username, String roleName);

    User loadUserByUsername(String username);

    User loadUserByEmail(String email);




}
