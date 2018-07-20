package com.example.demo.controller;

import com.example.demo.model.Profile;
import com.example.demo.model.UserPost;
import com.example.demo.services.UserService;
import com.example.demo.model.auth.AppUser;
import com.example.demo.model.auth.AppUserRepository;
import com.example.demo.model.repositories.ProfileRepository;
import com.example.demo.model.repositories.UserPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import com.example.demo.services.NewsService;
import com.example.demo.services.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import java.time.LocalDateTime;

@Controller
public class HomeController {
    @Autowired
    WeatherService weather;

    @Autowired
    NewsService news;

    @Autowired
    UserPostRepository posts;
    @Autowired
    UserService users;

    @Autowired
    ProfileRepository profiles;

    @RequestMapping("/")
    public String home2() {
        return "index";
    }
    @RequestMapping("/headlines")
    public String headlines(Model model) {
        model.addAttribute("articles", news.articles());
        return "news/headlines";
    }
    @RequestMapping("/forecasts")
    public String weatherForecasts(Model model) {
        model.addAttribute("forecasts", weather.forecasts());
        return "weather/forecasts";
    }

    @RequestMapping("/posting")
    public String postingPost(@ModelAttribute("newPost") UserPost post, Model model, Authentication authentication) {
        AppUser thisUser = users.findUser(authentication);
        if (thisUser.hasProfile()) {
            post.setWhoPosted(users.findProfile(authentication));
            post.setTimePosted(LocalDateTime.now());
            posts.save(post);
        }else{
            model.addAttribute("noProfile", true);
            model.addAttribute("profile", new Profile());
            return "users/profileform";
        }
        return "redirect:/";
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
        return "/users/profile";
    }
}
