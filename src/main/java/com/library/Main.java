package com.library;


import com.library.enums.Gender;
import com.library.enums.Role;
import com.library.models.Book;
import com.library.models.User;
import com.library.services.Impl.LibraryServicePriorityImpl;
import com.library.services.Impl.LibraryServiceFifoImpl;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Queue<User> users = new ArrayDeque<>(Arrays.asList(
                new User("Austin Eva", Gender.FEMALE, Role.IS_JUNIOR, 101),
                new User("Jame Tochi", Gender.MALE, Role.IS_JUNIOR, 102),
                new User("Eric Eme", Gender.MALE, Role.IS_SENIOR,  103),
                new User("Calabar Osi", Gender.MALE, Role.TEACHER, 104),
                new User("Praise Abu", Gender.MALE, Role.TEACHER, 105)
                ));

        Book book1 = new Book("Java 101", "Evaloper", true, 20221, 3);
        Book book2 = new Book("Java OOP", "Isi oma", true, 20222, 2);
        Book book3 = new Book("Java Generics", "Dera Classics", true, 20222, 5);
        Book book4 = new Book("Java Collections", "Chinny Odinma", true, 20222, 2);

        List<Book> bookList = new ArrayList<>(Arrays.asList(book1, book2, book3, book4));


        //Priority queue
        System.out.println("==============================");
        System.out.println("Print Priority");
        System.out.println("==============================");
        LibraryServicePriorityImpl libraryService = new LibraryServicePriorityImpl();

        //Add users to Queue
        users.forEach(libraryService::addUsersToQueue);


        // Implementation
        libraryService.borrowBook(users, bookList);

        System.out.println(" ");
        System.out.println("==============================");
        System.out.println("Print Fifo");
        System.out.println("==============================");
        LibraryServiceFifoImpl serviceImpl2 = new LibraryServiceFifoImpl();

        // Add users to queue
        users.forEach(serviceImpl2::addUsersToQueue);

// Implementation
        System.out.println(serviceImpl2.borrowBook(users, bookList));  // Don't pass the users list




    }
}
