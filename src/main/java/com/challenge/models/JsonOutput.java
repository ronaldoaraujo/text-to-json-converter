package com.challenge.models;

import java.util.List;

public class JsonOutput {
    private List<User> users;

    public JsonOutput() {
    }

    public JsonOutput(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return this.users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
