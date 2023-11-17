package com.weparty.api.Controller;

import com.weparty.api.Model.EventModel;
import com.weparty.api.Model.UserSystemModel;
import com.weparty.api.Service.UserSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEvent(@PathVariable Long id, @RequestBody UserSystemModel updatedUser) {
        Object result = userSystemService.update(id, updatedUser);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
        Object result = userSystemService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable Long id) {
        Object result = userSystemService.findById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
