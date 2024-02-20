package com.library.models;

import com.library.enums.Gender;
import com.library.enums.Role;

public abstract class User {
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getQueueOrder() {
        return queueOrder;
    }

    public void setQueueOrder(int queueOrder) {
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
