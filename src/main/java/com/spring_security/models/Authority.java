package com.spring_security.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "authority")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String authority;

    public Authority() {
    }

    public Authority(String authority) {
        this.authority = authority;
    }

    @ManyToMany(mappedBy = "authorities")
    private List<User> users = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
