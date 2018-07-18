package com.example.demo.services;

import com.example.demo.model.auth.AppUser;
import com.example.demo.model.auth.AppUserRepository;
import com.example.demo.model.auth.UserRole;
import com.example.demo.model.auth.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    AppUserRepository users;

    @Autowired
    UserRoleRepository roles;

    public void addUser(String ausername, String apassword, String role) {
        AppUser user = new AppUser();
        user.setUsername(ausername);
        user.setPassword(apassword);
        user.addRole(roles.findByRole(role));
    }

    public void addUser(String ausername, String apassword, String[] roles) {
        AppUser user = new AppUser();
        user.setUsername(ausername);
        user.setPassword(apassword);
        for(String role : roles)
            user.addRole(this.roles.findByRole(role));
    }

    public void addAppRole(String role) {
        UserRole newRole = new UserRole(role);
        roles.save(newRole);
    }

    public UserRole findRole(String role) {
        return roles.findByRole(role);
    }

    public void saveMe(AppUser aUser) {
        users.save(aUser);
    }
}
