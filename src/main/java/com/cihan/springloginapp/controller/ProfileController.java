package com.cihan.springloginapp.controller;

import com.cihan.springloginapp.entities.User;
import com.cihan.springloginapp.services.TaskService;
import com.cihan.springloginapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ProfileController {


    private TaskService taskService;
    private UserService userService;
    @Autowired
    public ProfileController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }



    @GetMapping("/profile")
    public String showProfilePage(Model model, Principal principal) {

        String email = principal.getName();
        User user = userService.findByEmail(email);

        model.addAttribute("tasks", taskService.findUserTask(user));

        return "fragments/profile";
    }
}
