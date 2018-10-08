package com.cihan.springloginapp.services;

import com.cihan.springloginapp.entities.Task;
import com.cihan.springloginapp.entities.User;
import com.cihan.springloginapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public void addTask(Task task, User user){
        task.setUser(user);
        taskRepository.save(task);
    }

    public List<Task> findUserTask(User user){
        return taskRepository.findByUser(user);
    }

}
