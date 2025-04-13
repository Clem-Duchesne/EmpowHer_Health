package com.dev.requests;

import java.util.Date;

public class RegisterUserRequest {
    private String username;
    private String password;
    private Date birthDate;

    public RegisterUserRequest(String username, String password, Date birthDate){
        this.username = username;
        this.password = password;
        this.birthDate = birthDate;
    }
    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

}