package com.weparty.api.Model;

import lombok.Data;

@Data
public class UserResponseModel {
    private Long userId;
    private String name;

    private String image;
    private String email;

    public UserResponseModel(Long userId, String name, String email, String image) {
        this.userId = userId;
        this.name = name;
        this.image = image;
        this.email = email;
    }

    // Constructors, getters, setters, and any other methods if needed
}
