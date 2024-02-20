package com.library.models;

import com.library.enums.Role;

import java.util.Comparator;

public class UserComparator implements Comparator<User> {
    @Override
    public int compare(User u1, User u2) {
        if (u1.getRole().equals(Role.TEACHER) && u2.getRole().equals(Role.STUDENT)){
            return -1;
        } else if (u1.getRole().equals(Role.STUDENT) && u2.getRole().equals(Role.TEACHER))  {
            return 1;
        } else if (u1.getRole().equals(Role.STUDENT) && u2.getRole().equals(Role.STUDENT)){
            Student student1 = (Student) u1;
            Student student2 = (Student) u2;
            if (student1.isSenior() && !student2.isSenior()){
                return -1;
            } else if (!student1.isSenior() && student2.isSenior()) {
                return 1;
            }

        }
        int queueOrderComparison = Integer.compare(u1.getQueueOrder(), u2.getQueueOrder());
        // Return the result of the comparison
        return queueOrderComparison;
    }
}
