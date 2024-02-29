package com.library.models;

import com.library.enums.Gender;
import com.library.enums.Role;
import lombok.Data;

@Data

public class User {
    private String fullName;
    private Gender gender;
    private Role role;
    private int queueOrder;

    public User(String fullName, Gender gender, Role role, int queueOrder) {
        this.fullName = fullName;
        this.gender = gender;
        this.role = role;
        this.queueOrder = queueOrder;
    }





    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", gender=" + gender +
                ", role=" + role +
                ", queueOrder=" + queueOrder +
                '}';
    }
}
