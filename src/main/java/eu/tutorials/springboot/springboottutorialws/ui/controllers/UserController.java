package eu.tutorials.springboot.springboottutorialws.ui.controllers;

import eu.tutorials.springboot.springboottutorialws.exceptions.UserServiceException;
import eu.tutorials.springboot.springboottutorialws.ui.model.request.UpdateUserDetailsRequest;
import eu.tutorials.springboot.springboottutorialws.ui.model.request.UserDetailsRequest;
import eu.tutorials.springboot.springboottutorialws.ui.model.response.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@RestController
@RequestMapping("/users")
public class UserController {

    Map<String, UserRest> users;

    @GetMapping
    public String getUsers(@RequestParam(value = "page") int page, @RequestParam(value = "limit", defaultValue = "2") int limit,
                           @RequestParam(value = "sort", required = false) String sort) {
        return "get users was called with page " + page + " and limit " + limit + " and sort " + sort;
    }

    @GetMapping(path = "/{userId}",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            })
    public ResponseEntity<UserRest> getUser(@PathVariable String userId) {

        if(true) throw  new UserServiceException("Custom exception");

        if (users.containsKey(userId)) {

            return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @PostMapping(
            consumes = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            })
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequest userDetailsRequest) {

        UserRest returnValue = new UserRest();
        returnValue.setEmail(userDetailsRequest.getEmail());
        returnValue.setFirstName(userDetailsRequest.getFirstName());
        returnValue.setLasttName(userDetailsRequest.getLasttName());

        String userId = UUID.randomUUID().toString();
        returnValue.setUserId(userId);
        if (users == null) users = new HashMap<>();
        users.put(userId, returnValue);
        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
    }

    @PutMapping(path = "/{userId}",
            consumes = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            })
    public UserRest updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailsRequest userDetails) {

        UserRest storedUserDetails = users.get(userId);
        storedUserDetails.setFirstName(userDetails.getFirstName());
        storedUserDetails.setLasttName(userDetails.getLasttName());

        users.put(userId, storedUserDetails);

        return storedUserDetails;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        users.remove(id);

        return ResponseEntity.noContent().build();
    }

}
