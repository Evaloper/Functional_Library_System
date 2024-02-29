package com.library.services.Impl;

import com.library.exception.BookNotFoundException;
import com.library.exception.NoUserOnQueueException;
import com.library.models.Book;
import com.library.models.User;
import com.library.services.LibraryService;

import java.util.*;

public class LibraryServiceFifoImpl implements LibraryService {

    private Queue<User> usersOnQueue;

    public LibraryServiceFifoImpl() {
        usersOnQueue = new LinkedList<>();
    }


    @Override
    public void addUsersToQueue(User user) {
        usersOnQueue.offer(user); // Add user to the end of the queue
    }

    @Override
    public String borrowBook(Queue<User> users, List<Book> books) {
        try {
            for (Book book : books) {
                if (book.getQuantity() <= 0) {
                    throw new BookNotFoundException(book.getBookTitle() + " is not available");
                }
            }

            int quantity = Math.min(books.stream().mapToInt(Book::getQuantity).sum(), usersOnQueue.size());
            if (quantity <= 0) {
                throw new NoUserOnQueueException("No user in queue or no books available");
            }

            StringBuilder result = new StringBuilder();
            Iterator<User> userIterator = usersOnQueue.iterator();
            for (int i = 0; i < quantity && userIterator.hasNext(); i++) {
                User user = userIterator.next();
                Book book = books.get(i % books.size()); // Cycle through books
                String borrowingResult = user.getFullName() + " has taken " + book.getBookTitle() + "\n";
                result.append(borrowingResult);
                System.out.print(borrowingResult); // Print borrowing result
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
        return book.getBookTitle() + " successfully returned by " + name.getFullName();
    }
}