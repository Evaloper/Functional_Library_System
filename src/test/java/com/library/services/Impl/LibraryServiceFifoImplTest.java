package com.library.services.Impl;

import com.library.enums.Gender;
import com.library.enums.Role;
import com.library.models.Book;
import com.library.models.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryServiceFifoImplTest {

    @Test
    void testBorrowBook_WhenBookAvailable_ExpectUserTakesBook() {
        // Arrange
        Book book = new Book("The boy with the magic flute", "Rosemary Uroko", true, 201, 3);
        List<User> users = Arrays.asList(
                new User("Austin Eva", Gender.FEMALE, Role.STUDENT, 101),
                new User("Jame Tochi", Gender.MALE, Role.STUDENT, 102),
                new User("Eric Eme", Gender.MALE, Role.STUDENT,  103),
                new User("Calabar Osi", Gender.MALE, Role.TEACHER, 104),
                new User("Praise Abu", Gender.MALE, Role.TEACHER, 105)
        );
        LibraryServicePriorityImpl libraryService = new LibraryServicePriorityImpl();
        libraryService.addUsersToQueue(users.get(0));

        // Act
        String actual = libraryService.borrowBook(users, book);

        // Assert
        String expected = "Austin Eva has taken The boy with the magic flute";
        assertEquals(expected, actual);
    }




    @Test
    void returnBook() {
        Book book = new Book("The boy with the magic flute", "Rosemary Uroko", true, 201, 3);
        User student = new User("Chidera Okoro", Gender.FEMALE, Role.STUDENT, 101);

        LibraryServicePriorityImpl libraryServicePriority = new LibraryServicePriorityImpl();
        libraryServicePriority.addUsersToQueue(student);

        String actual = libraryServicePriority.returnBook(student, book);
        String expected = "The boy with the magic flute returned successfully by Chidera Okoro";

        assertEquals(expected, actual);
    }
}