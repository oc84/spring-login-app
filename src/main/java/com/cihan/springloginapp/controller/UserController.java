package com.cihan.springloginapp.controller;

import com.cihan.springloginapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String listUsers(Model model, @RequestParam(defaultValue = "") String name){
        model.addAttribute("users", userService.findByName(name));
        return "fragments/list";
    }
}
