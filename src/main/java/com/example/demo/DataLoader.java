package com.example.demo;

import com.example.demo.model.apis.randomuserapi.RandomUser;
import com.example.demo.model.apis.randomuserapi.RandomUsers;
import com.example.demo.model.auth.AppUser;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    UserService users;

    @Override
    public void run(String... args) throws Exception {

        //Create Roles
        users.addAppRole("SUSPENDED");
        users.addAppRole("ADMIN");
        users.addAppRole("USER");
        users.addAppRole("MANAGER");

        //Create users with single administrative rights
        users.addUser("auser","apassword","ADMIN");
        users.addUser("anotheruser","nopassword","USER");

        //Add multiple roles to a user (comma-separated)
        String[]rolesToAdd={"ADMIN","MANAGER"};

        users.addUser("multipleroleuser","password",rolesToAdd);

//        Random USER API - add users here:
        RestTemplate fromAPI = new RestTemplate();


        RandomUsers randomUsers =   fromAPI.getForObject("https://randomuser.me/api?results=10",RandomUsers.class);
        for (RandomUser eachuser: randomUsers.getResults()) {
            System.out.println("Image:"+eachuser.getImage().get("large"));
            System.out.println("Username:"+eachuser.getUsername());
            System.out.println("Password:"+eachuser.getUnEncryptedPassword());
            System.out.println("Email:"+eachuser.getEmail());

            // 'Convert' random user data into our app user data
            AppUser aUser = new AppUser();
            aUser.addRole(users.findRole("USER"));
            aUser.setPassword(eachuser.getUnEncryptedPassword());
            aUser.setUsername(eachuser.getUsername());
            users.saveMe(aUser);
        }

    }
}
