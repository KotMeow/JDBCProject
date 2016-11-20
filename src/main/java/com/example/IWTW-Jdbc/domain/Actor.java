package com.example.IWTW-Jdbc.domain;

public class Actor {

    private String name;
    private String role;
    private int CDid;

    public Actor(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public int getCDid() {
        return CDid;
    }

    public void setCDid(int CDid) {
        this.CDid = CDid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}