package org.example.entitites;

import java.io.Serializable;
public class Credentials implements Serializable {
    private String username;
    private String password;
    public Credentials(){}
    public  Credentials(String u,String p){password=p;username=u;}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}