package com.weparty.api.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "UserSystem")
public class UserSystemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name="name")
    private String name;

    @Column(name="image")
    private String image;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="document")
    private String document;

//    @ManyToMany
//    private List<UserSystemModel> userConnections;
}
