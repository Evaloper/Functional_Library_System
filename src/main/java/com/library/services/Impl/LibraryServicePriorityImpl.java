package com.library.services.Impl;

import com.library.enums.Role;
import com.library.exception.BookNotFoundException;
import com.library.exception.NoUserOnQueueException;
import com.library.models.Book;
import com.library.models.User;
//import com.library.models.UserComparator;
import com.library.services.LibraryService;
import lombok.Data;

import java.util.*;

public class LibraryServicePriorityImpl implements LibraryService {
    PriorityQueue<User> usersOnQueue;
    Comparator<User> userComparator = (u1, u2) -> u1.getRole().compareTo(u2.getRole());


    public LibraryServicePriorityImpl(){
        usersOnQueue = new PriorityQueue<>(userComparator);
    }

    @Override
    public void addUsersToQueue(User user) {
        usersOnQueue.add(user);
    }
//    @Override
//    public String borrowBook(List<User> users, Book book) {
//        try {
//            if (usersOnQueue.isEmpty()) {
//                throw new IllegalStateException("No user on queue");
//            }
//
//            // Lambda expression for printing with priority
//            usersOnQueue.forEach(user -> System.out.println(user.getFullName() + " has taken " + book.getBookTitle()));
//
//            List<String> borrowActions = new ArrayList<>();
//            usersOnQueue.forEach(user -> {
//                borrowActions.add(user.getFullName() + " has taken " + book.getBookTitle());
//            });
//            String result = String.join("\n", borrowActions);
//            usersOnQueue.clear();
//            return result.toString();
//        } catch (IllegalStateException e) {
//            System.out.println("Exception caught: " + e.getMessage());
//            return e.getMessage();
//        }
//    }

    @Override
    public String borrowBook(Queue<User> users, List<Book> books) {
        try {
            if (usersOnQueue.isEmpty()) {
                throw new NoUserOnQueueException("No user on queue");
            }

            for (Book book : books) {
                if (book.getQuantity() <= 0) {
                    throw new BookNotFoundException (book.getBookTitle() + " is not available");
                }
            }

            int totalQuantity = books.stream().mapToInt(Book::getQuantity).sum();
            int quantityToBorrow = Math.min(totalQuantity, usersOnQueue.size());
            if (quantityToBorrow <= 0) {
                throw new NoUserOnQueueException("No user in queue or no books available");
            }

            StringBuilder result = new StringBuilder();
            Iterator<User> userIterator = usersOnQueue.iterator();
            for (int i = 0; i < quantityToBorrow; i++) {
                User user = userIterator.next();
                Book book = books.get(i % books.size());
                String borrowingResult = user.getFullName() + " has taken " + book.getBookTitle() + "\n";
                result.append(borrowingResult);
                System.out.print(borrowingResult);
                book.setQuantity(book.getQuantity() - 1);
                userIterator.remove(); // Remove the user from the queue
            }

            return result.toString();
        } catch (IllegalStateException e) {
            System.out.println("Exception caught: " + e.getMessage());
            return e.getMessage();
        }
    }





    @Override
    public String returnBook(User name, Book book) {
        book.setQuantity(book.getQuantity() + 1);

        return book.getBookTitle() + " returned successfully by " + name.getFullName();
    }
}