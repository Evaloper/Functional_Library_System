package com.library.models;

import com.library.enums.Gender;
import com.library.enums.Role;

public class Student extends User{

    private boolean isSenior;

    private boolean isJunior;

    public Student(String fullName, Gender gender, Role role, int queueOrder, boolean isSenior, boolean isJunior) {
        super(fullName, gender, role, queueOrder);
        this.isSenior = isSenior;
        this.isJunior = isJunior;
    }

    public boolean isSenior() {
        return isSenior;
    }

    public void setSenior(boolean senior) {
        isSenior = senior;
    }

    public boolean isJunior() {
        return isJunior;
    }

    public void setJunior(boolean junior) {
        isJunior = junior;
    }

    @Override
    public String toString() {
        return "Student{" +
                "isSenior=" + isSenior +
                ", isJunior=" + isJunior +
                '}';
    }
}
