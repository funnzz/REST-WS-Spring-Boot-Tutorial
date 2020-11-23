package eu.tutorials.springboot.springboottutorialws.ui.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public String getUsers(@RequestParam(value = "page") int page, @RequestParam(value = "limit", defaultValue = "2") int limit,
                           @RequestParam(value = "sort", required = false) String sort) {
        return "get users was called with page "+ page +" and limit " + limit + " and sort " + sort;
    }

    @GetMapping(path = "/{userId}")
    public String getUser(@PathVariable String userId) {
        return "get user was called with userId: " + userId;
    }

    @PostMapping
    public String createUser() {
        return "create User was called";
    }

    @PutMapping
    public String updateUser() {
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "delete user was called";
    }

}
