package com.cihan.springloginapp;

import com.cihan.springloginapp.entities.Task;
import com.cihan.springloginapp.entities.User;
import com.cihan.springloginapp.services.TaskService;
import com.cihan.springloginapp.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringLoginAppApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    @Before
    public void initDb(){
        {
            User newUser = new User("testUser@mail.com", "testUser", "222163");
            userService.createUser(newUser);
        }
        {
            User newUser = new User("testAdmin@mail.com", "testAdmin", "123456" );
            userService.createAdmin(newUser);
        }

        Task userTask = new Task("05/08/2018", "02:29", "11:00", "You can sleep now");
        User user = userService.findByEmail("testUser@mail.com");
        taskService.addTask(userTask, user);
    }

    @Test
    public void testUser(){

        User user = userService.findByEmail("testUser@mail.com");
        assertNotNull(user);
        User admin = userService.findByEmail("testAdmin@mail.com");
        assertEquals(admin.getEmail(),"testAdmin@mail.com");
    }

    @Test
    public void testTask(){
        User user = userService.findByEmail("testUser@mail.com");
        List<Task> task = taskService.findUserTask(user);
        assertNotNull(task);
    }
}
