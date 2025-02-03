package com.mls.spring.controller;

import com.mls.spring.model.UserEntity;
import com.mls.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save-user")
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity user) {
        UserEntity userSaved = userService.saveUser(user);
        return ResponseEntity.ok(userSaved);
    }

    @GetMapping("/list-users")
    public List<UserEntity> listUsers(){
        return userService.listUsers();
    }

}
