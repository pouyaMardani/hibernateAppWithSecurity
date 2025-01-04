package com.example.demo.entity.role;

import lombok.Getter;

@Getter
public enum RoleType {

    EMPLOYEE("EMPLOYEE", "Employee"),
    MANAGER("MANAGER", "Manager"),
    ADMIN("ADMIN", "Admin");


    private final String value;
    private final String title;

    RoleType(String value, String title) {
        this.value = value;
        this.title = title;
    }
}
