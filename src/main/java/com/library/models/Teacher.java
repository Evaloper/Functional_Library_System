package com.library.models;

import com.library.enums.Gender;
import com.library.enums.Role;

public class Teacher extends User{
    private String department;

    public Teacher(String fullName, Gender gender, Role role, int queueOrder) {
        super(fullName, gender, role, queueOrder);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "department='" + department + '\'' +
                '}';
    }
}
