package com.javamaster.controller;


import com.javamaster.model.User;
import com.javamaster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Controller
public class UpdateController {

    @Autowired
    private UserService service;


    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String getPage(@RequestParam Long id, Model model) {
        User user = service.getUserById(id);
        model.addAttribute("user", user);
        return "updateUser";
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String getAddPost(@RequestParam Long id, @RequestParam String name
            , @RequestParam String last_name, @RequestParam String email, Model model) {
        User user = service.getUserById(id);
        user.setFirstName(name);
        user.setLastName(last_name);
        user.setEmail(email);
        service.updateUser(user);
        List<User> users = service.getListUsers();
        model.addAttribute("users", users);
        return "showUsers";
    }

}
