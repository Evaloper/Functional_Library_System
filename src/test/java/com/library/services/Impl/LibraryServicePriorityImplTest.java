package com.library.services.Impl;

import com.library.enums.Gender;
import com.library.enums.Role;
import com.library.models.Book;
import com.library.models.Student;
import com.library.models.Teacher;
import com.library.models.User;
import com.library.services.LibraryService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryServicePriorityImplTest {

    @Test
    void borrowBook() {
        Book book = new Book("The boy with the magic flute", "Rosemary Uroko", true, 201, 3);
        Student student = new Student("Chidera Okoro", Gender.FEMALE, Role.STUDENT, 101, true, false);
        Teacher teacher = new Teacher("Osas Mudia", Gender.MALE, Role.TEACHER, 101);

        LibraryServicePriorityImpl libraryServicePriority = new LibraryServicePriorityImpl();
        libraryServicePriority.addUsersToQueue(teacher);

        String actual = libraryServicePriority.borrowBook(teacher, book);
        String expected = "Osas Mudia has taken The boy with the magic flute";

        assertEquals(expected, actual);
    }

    @Test
    void returnBook() {
        Book book = new Book("The boy with the magic flute", "Rosemary Uroko", true, 201, 3);

        Teacher teacher = new Teacher("Osas Mudia", Gender.MALE, Role.TEACHER, 101);

        LibraryServicePriorityImpl libraryServicePriority = new LibraryServicePriorityImpl();
        libraryServicePriority.addUsersToQueue(teacher);

        String actual = libraryServicePriority.returnBook(teacher, book);
        String expected = "The boy with the magic flute returned successfully by Osas Mudia";

        assertEquals(expected, actual);
    }
}