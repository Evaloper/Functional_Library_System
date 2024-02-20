package com.library;


import com.library.enums.Gender;
import com.library.enums.Role;
import com.library.models.Book;
import com.library.models.Student;
import com.library.models.Teacher;
import com.library.services.Impl.LibraryServicePriorityImpl;
import com.library.services.Impl.LibraryServiceFifoImpl;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Austin Eva", Gender.FEMALE, Role.STUDENT, 101, false, true);
        Student student2 = new Student("Jame Tochi", Gender.MALE, Role.STUDENT, 102,true, false);
        Student student3 = new Student("Eric Eme", Gender.MALE, Role.STUDENT,  103, true, false);
        Teacher teacher1 = new Teacher("Calabar Osi", Gender.MALE, Role.TEACHER, 104);
        Teacher teacher2 = new Teacher("Praise Abu", Gender.MALE, Role.TEACHER, 105);

        Book book1 = new Book("Java 101", "Evaloper", true, 20221, 3);
        Book book2 = new Book("Java OOP", "Isi oma", true, 20222, 2);

        //Priority queue
        LibraryServicePriorityImpl libraryService = new LibraryServicePriorityImpl();
        libraryService.addUsersToQueue(student1);
        libraryService.addUsersToQueue(student2);
        libraryService.addUsersToQueue(student3);
        libraryService.addUsersToQueue(teacher1);
        libraryService.addUsersToQueue(teacher2);

        System.out.println(libraryService.borrowBook(teacher2, book1));
        System.out.println(libraryService.borrowBook(student2, book2));
        System.out.println(libraryService.borrowBook(student1, book1));
        System.out.println(libraryService.borrowBook(teacher1, book1));
        System.out.println(libraryService.borrowBook(student3, book1));
        System.out.println(libraryService.borrowBook(student3, book1));


        // First come, first served.
        LibraryServiceFifoImpl serviceImpl2 = new LibraryServiceFifoImpl();



        System.out.println("");
        System.out.println("***************");
        System.out.println("Implementation 2");

        System.out.println(serviceImpl2.borrowBook(student1, book2));
        System.out.println(serviceImpl2.borrowBook(student2, book2));
        System.out.println(serviceImpl2.borrowBook(student3, book1));
        System.out.println(serviceImpl2.borrowBook(teacher1, book2));

         //Jame Tochi returned Java OOP, now Java oop is available

        System.out.println(serviceImpl2.returnBook(student2, book2));
        System.out.println(serviceImpl2.borrowBook(student3, book1));
        System.out.println(serviceImpl2.borrowBook(teacher1, book2));
        System.out.println(serviceImpl2.borrowBook(student3, book2));

        System.out.println();


    }
}
