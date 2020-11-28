package eu.tutorials.springboot.springboottutorialws.userservice.impl;

import eu.tutorials.springboot.springboottutorialws.shared.Utils;
import eu.tutorials.springboot.springboottutorialws.ui.model.request.UserDetailsRequest;
import eu.tutorials.springboot.springboottutorialws.ui.model.response.UserRest;
import eu.tutorials.springboot.springboottutorialws.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    Map<String, UserRest> users;
    Utils utils;

    public UserServiceImpl() {
    }

    @Autowired
    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }

    @Override
    public UserRest createUser(UserDetailsRequest userDetailsRequest) {

        UserRest returnValue = new UserRest();
        returnValue.setEmail(userDetailsRequest.getEmail());
        returnValue.setFirstName(userDetailsRequest.getFirstName());
        returnValue.setLasttName(userDetailsRequest.getLasttName());

        String userId = utils.generateUserId();
        returnValue.setUserId(userId);

        if (users == null) users = new HashMap<>();
        users.put(userId, returnValue);

        return returnValue;
    }
}
