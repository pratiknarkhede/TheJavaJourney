package com.pratik.thejavajourney.collection_framework.custom_iterator;

import java.util.Iterator;

public class IteratorDemo {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(3);

        // Add books to the shelf
        bookShelf.addBook(new Book("Clean Code", "Robert Martin"));
        bookShelf.addBook(new Book("Effective Java", "Joshua Bloch"));
        bookShelf.addBook(new Book("Design Patterns", "Gang of Four"));
        Iterator<Book> iterator = bookShelf.iterator();
        while(iterator.hasNext()){
            Book book=iterator.next();
            System.out.println(book);
        }
    }
}
