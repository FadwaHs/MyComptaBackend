package com.codingart.mycompta.service.auth;

import com.codingart.mycompta.model.auth.Role;
import com.codingart.mycompta.model.auth.User;
import com.codingart.mycompta.repository.auth.RoleRepository;
import com.codingart.mycompta.repository.auth.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements  AccountService{

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public User AddNewUser(String username, String password, String email, String confirmPassword) {

        User user = userRepository.findByEmail(email);

        if(user != null) throw  new RuntimeException("this user already existe");
        if(!password.equals(confirmPassword)) throw  new RuntimeException("password not match");
        user = User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .email(email)
                .build();
        User savedUser =userRepository.save(user);
        return savedUser;
    }

    @Override
    public Role AddNewRole(String roleName) {

       Role role = roleRepository.findById(roleName).orElse(null);
       if(role!=null) throw  new RuntimeException("this role already exist");
       role  = Role.builder()
               .roleName(roleName)
               .build();

        return roleRepository.save(role);
    }

    @Override
    public void addRoletoUser(String username, String roleName) {

        User user  = userRepository.findByUsername(username);
        Role role  =  roleRepository.findById(roleName).get();

        List<Role> roleList = user.getRoleList();
        if (roleList == null) {
            roleList = new ArrayList<>();
            user.setRoleList(roleList);
        }
        user.getRoleList().add(role);
        // userRepository.save(user); // Dont need this because i already use @Transactional
    }

    @Override
    public void removeRoleFromUser(String username, String roleName) {
        User user  = userRepository.findByUsername(username);
        Role role  =  roleRepository.findById(roleName).get();
        user.getRoleList().remove(role);
    }

    @Override
    public User loadUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User loadUserByEmail(String email) {

        return userRepository.findByEmail(email);
    }
}
