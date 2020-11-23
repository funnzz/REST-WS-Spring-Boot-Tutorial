package eu.tutorials.springboot.springboottutorialws.ui.controllers;

import eu.tutorials.springboot.springboottutorialws.ui.model.response.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public String getUsers(@RequestParam(value = "page") int page, @RequestParam(value = "limit", defaultValue = "2") int limit,
                           @RequestParam(value = "sort", required = false) String sort) {
        return "get users was called with page " + page + " and limit " + limit + " and sort " + sort;
    }

    @GetMapping(path = "/{userId}", produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })
    public ResponseEntity<UserRest> getUser(@PathVariable String userId) {

        UserRest returnValue = new UserRest();
        returnValue.setEmail("aaa@mail.com");
        returnValue.setFirstName("rocky");
        returnValue.setLasttName("rambo");

        return new ResponseEntity<UserRest>(returnValue,HttpStatus.OK);
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
