package com.example.demo.controller;

import com.example.demo.model.auth.AppUserRepository;
import com.example.demo.model.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import com.example.demo.services.NewsService;
import com.example.demo.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @Autowired
    AppUserRepository users;

    @Autowired
    ProfileRepository profiles;

    @RequestMapping("/")
    public String home2() {
        return "index";
    }

    @RequestMapping("/settings")
    public String userSet(){
        return "usersettings";
    }
    @RequestMapping("/dm")
    public String userDM(){
        return "directmessages";
    }
    @RequestMapping("/friends")
    public String friends(){
        return "listFriends";
    }
    @RequestMapping("/noti")
    public String notifi(){
        return "noti";
    }


    @Autowired
    WeatherService weather;

    @Autowired
    NewsService news;
//
//    @RequestMapping("/") @ResponseBody
//    public String home(){
//        return news.toString();
//
//    }

    @RequestMapping("/profile")
    public String showProfile(Model model, Authentication auth){
        model.addAttribute("profile", profiles.findByUsername(auth.getName()));
        System.out.println(profiles.findByUsername(auth.getName()).toString());
        return "profile";
    }
}
