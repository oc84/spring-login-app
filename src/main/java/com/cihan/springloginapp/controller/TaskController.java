package com.cihan.springloginapp.controller;

import com.cihan.springloginapp.entities.Task;
import com.cihan.springloginapp.services.TaskService;
import com.cihan.springloginapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class TaskController {


    private TaskService taskService;

    private UserService userService;

    @Autowired
    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping("/addTask")
    public String taskForm(String email, Model model, HttpSession session){

        session.setAttribute("email", email);
        model.addAttribute("task", new Task());
        return "fragments/taskForm";
    }

    @PostMapping("/addTask")
    public String addTask(@Valid Task task, BindingResult bindingResult, HttpSession session){
        if(bindingResult.hasErrors()){
            return "fragments/taskForm";
        }
        String email = (String) session.getAttribute("email");
        taskService.addTask(task, userService.findByEmail(email));
        return "redirect:/users";
    }
}
