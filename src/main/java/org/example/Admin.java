package org.example;

import static org.example.User.*;

public class Admin implements User {
    private String username;
    private String password;



    public Admin(String username, String password) {
        super();
        this.username=username;
        this.password=password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public  boolean login(Admin admin1) {
        return admin1.getUsername().equals("admin") && admin1.getPassword().equals("admin123");
    }

    @Override
    public void register() {

    }

    @Override
    public void login() {

    }
}

