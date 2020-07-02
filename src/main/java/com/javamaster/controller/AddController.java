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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@Controller
public class AddController extends HttpServlet {

    @Autowired
    private UserService service;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getPage() {
            return "addUser";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@RequestParam String name, @RequestParam String last_name
            , @RequestParam String email, Model model) {
        User user = new User(name, last_name, email);
        service.addUser(user);
        List<User> users = service.getListUsers();
        model.addAttribute("users", users);
        return "showUsers";
    }



}

