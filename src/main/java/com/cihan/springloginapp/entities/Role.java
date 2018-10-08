package com.cihan.springloginapp.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @Size(max = 15)
    private String name;
    @ManyToMany(mappedBy = "roles")
    private List<User>users;

    public Role(String name) {
        this.name = name;
    }
    public Role() { }

    public Role(String name, List<User> users) {
        this.name = name;
        this.users = users;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }
}
