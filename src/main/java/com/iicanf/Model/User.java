package com.iicanf.Model;

import lombok.Data;

@Data
public class User {
    private int age;
    private String name;
    private String address;

    public static User create() {
        User user = new User();
        user.setAddress("i live in silver");
        return user;
    }
}
