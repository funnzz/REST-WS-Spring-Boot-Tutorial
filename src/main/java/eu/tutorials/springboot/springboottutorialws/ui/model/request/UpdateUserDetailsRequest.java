package eu.tutorials.springboot.springboottutorialws.ui.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserDetailsRequest {

    @NotNull(message="first name cannot be null")
    @Size(min=3, message = "first name is wrong")
    private String firstName;
    @NotNull(message="last name cannot be null")
    private String lasttName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLasttName() {
        return lasttName;
    }

    public void setLasttName(String lasttName) {
        this.lasttName = lasttName;
    }
}
