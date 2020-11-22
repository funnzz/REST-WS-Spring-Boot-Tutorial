package eu.tutorials.springboot.springboottutorialws.ui.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping()
    public String getUser(){
        return "get user was called";
    }

    @PostMapping
    public String createUser(){
        return "create User was called";
    }

    @PutMapping
    public String updateUser(){
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser(){
        return "delete user was called";
    }

}
