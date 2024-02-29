package com.library.services.Impl;

import com.library.enums.Gender;
import com.library.enums.Role;
import com.library.models.Book;
import com.library.models.User;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class LibraryServicePriorityImplTest {

    @Test
    void testBorrowBook_WhenUserOnQueue_ExpectUserTakesBook() {
        // Arrange
        Book book1 = new Book("Java 101", "Evaloper", true, 20221, 3);
        Book book2 = new Book("Java OOP", "Isi oma", true, 20222, 2);
        Book book3 = new Book("Java Generics", "Dera Classics", true, 20222, 5);
        Book book4 = new Book("Java Collections", "Chinny Odinma", true, 20222, 2);

        List<Book> bookList = new ArrayList<>(Arrays.asList(book1, book2, book3, book4));
        Queue<User> users = new ArrayDeque<>( Arrays.asList(
                new User("Austin Eva", Gender.FEMALE, Role.STUDENT, 101),
                new User("Jame Tochi", Gender.MALE, Role.STUDENT, 102),
                new User("Eric Eme", Gender.MALE, Role.STUDENT,  103),
                new User("Calabar Osi", Gender.MALE, Role.TEACHER, 104),
                new User("Praise Abu", Gender.MALE, Role.TEACHER, 105)
        ));
        LibraryServicePriorityImpl libraryService = new LibraryServicePriorityImpl();
        libraryService.addUsersToQueue(users.peek()); // Adding Calabar Osi to the queue

        // Act
        String actual = libraryService.borrowBook(users, bookList);

        // Assert
        String expected = "Austin Eva has taken Java 101\n";
        assertEquals(expected, actual);
    }

    @Test
    void testBorrowBook_WhenNoUsersOnQueue() {
        // Arrange
        Book book1 = new Book("Java 101", "Evaloper", true, 20221, 3);
        Book book2 = new Book("Java OOP", "Isi oma", true, 20222, 2);
        Book book3 = new Book("Java Generics", "Dera Classics", true, 20222, 5);
        Book book4 = new Book("Java Collections", "Chinny Odinma", true, 20222, 2);

        List<Book> bookList = new ArrayList<>(Arrays.asList(book1, book2, book3, book4));


        Queue<User> users = new ArrayDeque<>(Arrays.asList(
                new User("Austin Eva", Gender.FEMALE, Role.STUDENT, 101),
                new User("Jame Tochi", Gender.MALE, Role.STUDENT, 102),
                new User("Eric Eme", Gender.MALE, Role.STUDENT,  103),
                new User("Calabar Osi", Gender.MALE, Role.TEACHER, 104),
                new User("Praise Abu", Gender.MALE, Role.TEACHER, 105)
        ));
        LibraryServicePriorityImpl libraryService = new LibraryServicePriorityImpl();

        // Act
        String actual = libraryService.borrowBook(users, bookList);

        // Assert
        assertEquals("No user on queue", actual);
    }



    @Test
    void returnBook() {

        //Arrange
        Book book = new Book("The boy with the magic flute", "Rosemary Uroko", true, 201, 3);

        User teacher = new User("Osas Mudia", Gender.MALE, Role.TEACHER, 101);

        LibraryServicePriorityImpl libraryServicePriority = new LibraryServicePriorityImpl();
        libraryServicePriority.addUsersToQueue(teacher);

        //Act
        String actual = libraryServicePriority.returnBook(teacher, book);
        String expected = "The boy with the magic flute returned successfully by Osas Mudia";

        //Assert
        assertEquals(expected, actual);
    }
}