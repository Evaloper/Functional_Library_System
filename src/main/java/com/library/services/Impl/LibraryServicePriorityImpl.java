package com.library.services.Impl;

import com.library.models.Book;
import com.library.models.User;
import com.library.models.UserComparator;
import com.library.services.LibraryService;

import java.util.PriorityQueue;

public class LibraryServicePriorityImpl implements LibraryService {
    PriorityQueue<User> usersOnQueue;
//    Map<Books, Integer> availableBooks;


    public LibraryServicePriorityImpl(){
        usersOnQueue = new PriorityQueue<>(new UserComparator());
//        availableBooks = new HashMap<>();
    }

//    @Override
//    public void addBooks(Books book, int quantity) {
//        int currentQuantity = availableBooks.getOrDefault(book, 0);
//        availableBooks.put(book, currentQuantity + quantity);
//
//    }

    @Override
    public void addUsersToQueue(User user) {
        usersOnQueue.add(user);
    }

    @Override
    public String borrowBook(User name, Book book) {
        if (usersOnQueue.isEmpty()){
            return "No user on queue";
        }

        User user = usersOnQueue.poll();
        assert user != null;
        return user.getFullName() + " has taken " + book.getBookTitle();
    }




    @Override
    public String returnBook(User name, Book book) {
        book.setQuantity(book.getQuantity() + 1);

        return book.getBookTitle() + " returned successfully by " + name.getFullName();
    }
}