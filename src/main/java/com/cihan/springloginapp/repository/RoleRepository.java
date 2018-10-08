package com.cihan.springloginapp.repository;

import com.cihan.springloginapp.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
}
