package com.library;


import com.library.enums.Gender;
import com.library.enums.Role;
import com.library.models.Book;
import com.library.models.User;
import com.library.services.Impl.LibraryServicePriorityImpl;
import com.library.services.Impl.LibraryServiceFifoImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>(Arrays.asList(
                new User("Austin Eva", Gender.FEMALE, Role.IS_JUNIOR, 101),
                new User("Jame Tochi", Gender.MALE, Role.IS_JUNIOR, 102),
                new User("Eric Eme", Gender.MALE, Role.IS_SENIOR,  103),
                new User("Calabar Osi", Gender.MALE, Role.TEACHER, 104),
                new User("Praise Abu", Gender.MALE, Role.TEACHER, 105)
                ));

        Book book1 = new Book("Java 101", "Evaloper", true, 20221, 3);
        Book book2 = new Book("Java OOP", "Isi oma", true, 20222, 2);
        Book book3 = new Book("Java Generics", "Dera Classics", true, 20222, 1);
        Book book4 = new Book("Java Collections", "Chinny Odinma", true, 20222, 2);

        List<Book> bookList = new ArrayList<>(Arrays.asList(book1, book2, book3, book4));


        //Priority queue
        System.out.println("==============================");
        System.out.println("Print Priority");
        System.out.println("==============================");
        LibraryServicePriorityImpl libraryService = new LibraryServicePriorityImpl();
        libraryService.addUsersToQueue(users.get(0));
        libraryService.addUsersToQueue(users.get(1));
        libraryService.addUsersToQueue(users.get(2));
        libraryService.addUsersToQueue(users.get(3));
        libraryService.addUsersToQueue(users.get(4));

        // Implementation
        libraryService.borrowBook(users, book2);

        System.out.println(" ");
        System.out.println("==============================");
        System.out.println("Print Fifo");
        System.out.println("==============================");
        LibraryServiceFifoImpl serviceImpl2 = new LibraryServiceFifoImpl();
        serviceImpl2.addUsersToQueue(users.get(0));
        serviceImpl2.addUsersToQueue(users.get(1));
        serviceImpl2.addUsersToQueue(users.get(2));
        serviceImpl2.addUsersToQueue(users.get(3));
        serviceImpl2.addUsersToQueue(users.get(4));

        //Implementation
        System.out.println(serviceImpl2.borrowBook(users, book1));



    }
}
