package com.library.services;

import com.library.models.Book;
import com.library.models.User;

import java.util.List;
import java.util.Queue;

public interface LibraryService {

//    public void addBooks(Books book, int quantity);

    public void addUsersToQueue(User user);

    public  String borrowBook(Queue<User> users, List<Book> books);

    public String returnBook(User name, Book book);
}
