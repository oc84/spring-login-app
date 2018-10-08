package com.cihan.springloginapp.repository;

import com.cihan.springloginapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByEmail(String email);

    List<User> findByNameLike(String name);
}