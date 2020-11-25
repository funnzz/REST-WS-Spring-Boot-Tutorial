package eu.tutorials.springboot.springboottutorialws.ui.model.request;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailsRequest {

    @NotNull(message="first name cannot be null")
    @Size(min=3, message = "first name is wrong")
    private String firstName;
    @NotNull(message="last name cannot be null")
    private String lasttName;
    @NotNull(message="email cannot be null")
    @Email
    private String email;
    @NotNull
    @Size(min=8, max=16, message = "Password is wrong")
    private String password;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
