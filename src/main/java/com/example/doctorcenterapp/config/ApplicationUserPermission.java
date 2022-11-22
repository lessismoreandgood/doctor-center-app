package com.example.doctorcenterapp.config;

public enum ApplicationUserPermission {
    USER_READ("user:read"),
    USER_WRITE("user:write"),
    DOCTOR_READ("doctor:read"),
    DOCTOR_WRITE("doctor:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
