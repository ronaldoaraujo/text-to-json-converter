package com.challenge.models;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof JsonOutput)) {
            return false;
        }
        JsonOutput jsonOutput = (JsonOutput) o;
        return Objects.equals(users, jsonOutput.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }
}
