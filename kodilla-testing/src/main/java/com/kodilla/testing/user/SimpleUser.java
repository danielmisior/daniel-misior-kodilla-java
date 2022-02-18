package com.kodilla.testing.user;

public class SimpleUser {

    private String username;
    private String realName;

    public SimpleUser (String userName) {
        this.username = userName;
    }

    public SimpleUser (String username, String realName) {
        this.username = username;
        this.realName = realName;
    }

    public String getUserName() {
        return username;
    }

    public String getRealName() {
        return realName;
    }
}
