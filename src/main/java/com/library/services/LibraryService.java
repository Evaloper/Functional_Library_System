package com.library.services;

import com.library.models.Book;
import com.library.models.User;

import java.util.List;

public interface LibraryService {

//    public void addBooks(Books book, int quantity);

    public void addUsersToQueue(User user);

    public  String borrowBook(List <User> users, Book book);

    public String returnBook(User name, Book book);
}
