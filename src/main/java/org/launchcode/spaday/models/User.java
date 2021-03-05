package org.launchcode.spaday.models;

import javax.validation.constraints.*;

public class User {
    @NotEmpty(message = "Please enter a username")
    @Size(min = 5, max = 15)
    private String username;

    @Email(message ="Please enter a valid email")
    private String email;

    @NotEmpty(message = "Please enter a password")
    @Size(min=6, max=20)
    private String password;

    @NotNull(message = "Passwords do not match.")
    private String verifyPassword;

    public User() {
    }

    public User(String username, String email, String password, String verifyPassword) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.verifyPassword = verifyPassword;
    }

    private void checkPassword(String password, String verifyPassword) {
        if (!password.equals(verifyPassword)) {
            this.verifyPassword = null;
        }
    }




    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        checkPassword(this.password, this.verifyPassword);
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword(this.password, this.verifyPassword);
        System.out.println(verifyPassword);
    }
}
