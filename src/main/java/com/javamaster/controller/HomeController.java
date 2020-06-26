package com.javamaster.controller;

import com.javamaster.model.User;
import com.javamaster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserService service;

    @RequestMapping("/")
    public String getIndex(Model model){
        List<User>users = service.getListUsers();
        model.addAttribute("users", users);
        return "showUsers";
    }

    @RequestMapping("/welcome")
    public String getWelcome(){
        return "index";
    }
}
