package eu.tutorials.springboot.springboottutorialws.exceptions;

public class UserServiceException extends RuntimeException {

    private static final long serialVersionUID = 10561160011958623L;

    public UserServiceException(String message){
        super(message);
    }
}
