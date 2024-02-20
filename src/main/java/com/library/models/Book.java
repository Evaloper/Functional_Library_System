package com.library.models;

public class Book {
    private String bookTitle;
    private String bookAuthor;
    private  boolean available;
    private int serialNumber;
    private int quantity;

    public Book(String bookTitle, String bookAuthor, boolean available, int serialNumber, int quantity) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.available = available;
        this.serialNumber = serialNumber;
        this.quantity = quantity;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Books{" +
                "bookTitle='" + bookTitle + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", available=" + available +
                ", serialNumber=" + serialNumber +
                ", quantity=" + quantity +
                '}';
    }
}
