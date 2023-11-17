package com.weparty.api.Model;

import lombok.Data;

@Data
public class UserResponseModel {
    private Long userId;
    private String name;
    private String email;

    public UserResponseModel(Long userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    // Constructors, getters, setters, and any other methods if needed
}
