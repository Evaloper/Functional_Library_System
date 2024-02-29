package com.library.services.Impl;

import com.library.enums.Role;
import com.library.models.Book;
import com.library.models.User;
//import com.library.models.UserComparator;
import com.library.services.LibraryService;
import lombok.Data;

import java.util.*;

public class LibraryServicePriorityImpl implements LibraryService {
    PriorityQueue<User> usersOnQueue;
    Comparator<User> userComparator = (u1, u2) -> u1.getRole().compareTo(u2.getRole());


    public LibraryServicePriorityImpl(){
        usersOnQueue = new PriorityQueue<>(userComparator);
    }

    @Override
    public void addUsersToQueue(User user) {
        usersOnQueue.add(user);
    }
    @Override
    public String borrowBook(List<User> users, Book book) {
        try {
            if (usersOnQueue.isEmpty()) {
                throw new IllegalStateException("No user on queue");
            }

            // Lambda expression for printing with priority
            usersOnQueue.forEach(user -> System.out.println(user.getFullName() + " has taken " + book.getBookTitle()));

            List<String> borrowActions = new ArrayList<>();
            usersOnQueue.forEach(user -> {
                borrowActions.add(user.getFullName() + " has taken " + book.getBookTitle());
            });
            String result = String.join("\n", borrowActions);
            usersOnQueue.clear();
            return result.toString();
        } catch (IllegalStateException e) {
            System.out.println("Exception caught: " + e.getMessage());
            return e.getMessage();
        }
    }





    @Override
    public String returnBook(User name, Book book) {
        book.setQuantity(book.getQuantity() + 1);

        return book.getBookTitle() + " returned successfully by " + name.getFullName();
    }
}