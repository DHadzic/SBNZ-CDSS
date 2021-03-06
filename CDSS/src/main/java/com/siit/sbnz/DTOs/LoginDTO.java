package com.siit.sbnz.DTOs;

import java.io.Serializable;

import javax.validation.constraints.NotNull;


public class LoginDTO implements Serializable {

    @NotNull
    private String username;
    @NotNull
    private String password;

    public LoginDTO() { }

    public LoginDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }


    @Override
    public String toString() {
        return "LoginDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
