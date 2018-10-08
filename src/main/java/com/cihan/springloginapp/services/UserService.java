package com.cihan.springloginapp.services;

import com.cihan.springloginapp.entities.Role;
import com.cihan.springloginapp.entities.User;
import com.cihan.springloginapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void createUser(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role userRole = new Role("USER");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);
    }

    public void createAdmin(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role userRole = new Role("ADMIN");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);
    }
    public User findByEmail(String email) {

        return userRepository.findByEmail(email);
    }
    public boolean isUserPresent(String email){
        User u = userRepository.findByEmail(email);
        return u != null;
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }
    public List<User> findByName(String name){
        return userRepository.findByNameLike("%"+name+"%");
    }
}
