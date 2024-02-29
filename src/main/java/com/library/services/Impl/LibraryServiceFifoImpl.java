package com.library.services.Impl;

import com.library.models.Book;
import com.library.models.User;
import com.library.services.LibraryService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LibraryServiceFifoImpl implements LibraryService {

    private Queue<User> usersOnQueue;

    public LibraryServiceFifoImpl() {
        usersOnQueue = new LinkedList<>();
    }


    @Override
    public void addUsersToQueue(User user) {
        usersOnQueue.offer(user); // Add user to the end of the queue
    }

    @Override
    public String borrowBook(List<User> users, Book book) {
        try {
            if (book.getQuantity() <= 0) {
                throw new IllegalStateException(book.getBookTitle() + " is not available");
            }

            int quantity = Math.min(book.getQuantity(), usersOnQueue.size());
            if (quantity <= 0) {
                throw new IllegalStateException("No user in queue");
            }

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < quantity; i++) {
                User user = usersOnQueue.poll();
                String borrowingResult = user.getFullName() + " has taken " + book.getBookTitle() + "\n";
                result.append(borrowingResult);
                System.out.print(borrowingResult); // Print borrowing result
            }

            book.setQuantity(book.getQuantity() - quantity);
            return result.toString();
        } catch (IllegalStateException e) {
            System.out.println("Exception caught: " + e.getMessage());
            return e.getMessage();
        }
    }


    @Override
    public String returnBook(User name, Book book) {
        book.setQuantity(book.getQuantity() + 1);
        return book.getBookTitle() + " successfully returned by " + name.getFullName();
    }
}