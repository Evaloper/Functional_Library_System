package com.library.services.Impl;

import com.library.enums.Gender;
import com.library.enums.Role;
import com.library.models.Book;
import com.library.models.Student;
import com.library.models.Teacher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryServiceFifoImplTest {

    @Test
    void borrowBook() {
        Book book = new Book("The boy with the magic flute", "Rosemary Uroko", true, 201, 3);
        Student student = new Student("Chidera Okoro", Gender.FEMALE, Role.STUDENT, 101, true, false);

        LibraryServicePriorityImpl libraryServicePriority = new LibraryServicePriorityImpl();
        libraryServicePriority.addUsersToQueue(student);

        String actual = libraryServicePriority.borrowBook(student, book);;
        String expected;
        if (book.getQuantity() > 0){
             expected = "Chidera Okoro has taken The boy with the magic flute";
        } else {
            expected= "The boy with the magic flute taken";
        }



        assertEquals(expected, actual);
    }

    @Test
    void returnBook() {
        Book book = new Book("The boy with the magic flute", "Rosemary Uroko", true, 201, 3);
        Student student = new Student("Chidera Okoro", Gender.FEMALE, Role.STUDENT, 101, true, false);

        LibraryServicePriorityImpl libraryServicePriority = new LibraryServicePriorityImpl();
        libraryServicePriority.addUsersToQueue(student);

        String actual = libraryServicePriority.returnBook(student, book);
        String expected = "The boy with the magic flute returned successfully by Chidera Okoro";

        assertEquals(expected, actual);
    }
}