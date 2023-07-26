package com.codingart.mycompta.service.auth;


import com.codingart.mycompta.model.auth.Role;
import com.codingart.mycompta.model.auth.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User appuser =  accountService.loadUserByEmail(email);
        if(appuser == null) throw new UsernameNotFoundException("not found");

       String[] roles = appuser.getRoleList().stream().map(u->u.getRoleName()).toArray(String[]::new);
        UserDetails userDetails  = org.springframework.security.core.userdetails.User
                                   .withUsername(appuser.getEmail())
                                   .password(appuser.getPassword())
                                   .authorities(roles).build();
        return userDetails;
    }
}
