package com.library.services.Impl;

import com.library.models.Book;
import com.library.models.User;
import com.library.services.LibraryService;

import java.util.LinkedList;
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
    public String borrowBook(User user, Book book) {
        if (book.getQuantity() > 0) {
            book.setQuantity(book.getQuantity() - 1); // Decrement the quantity of the book
            return book.getBookTitle() + " borrowed successfully by " + user.getFullName();
        } else {
            return book.getBookTitle() + " taken"; // Book is not available
        }
    }

    @Override
    public String returnBook(User name, Book book) {
        book.setQuantity(book.getQuantity() + 1);
        return book.getBookTitle() + " successfully returned by " + name.getFullName();
    }
}