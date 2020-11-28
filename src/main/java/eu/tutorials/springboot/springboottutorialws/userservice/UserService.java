package eu.tutorials.springboot.springboottutorialws.userservice;

import eu.tutorials.springboot.springboottutorialws.ui.model.request.UserDetailsRequest;
import eu.tutorials.springboot.springboottutorialws.ui.model.response.UserRest;

public interface UserService {

    UserRest createUser(UserDetailsRequest userDetailsRequest);
}
