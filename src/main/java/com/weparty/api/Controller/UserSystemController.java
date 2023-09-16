package com.weparty.api.Controller;

import com.weparty.api.Model.UserSystemModel;
import com.weparty.api.Service.UserSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserSystemController {

    @Autowired
    private UserSystemService userSystemService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserSystemModel addUser(@RequestBody UserSystemModel userSystemModel) {
        return (UserSystemModel) userSystemService.store(userSystemModel);
    }


    @GetMapping
    public List<UserSystemModel> listAll() {
        return userSystemService.index();
    }

}
