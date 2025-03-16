package com.pratik.thejavajourney.collection_framework.custom_iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BookShelf implements Iterable<Book> {
    private Book[] books;
    private int numberOfBooks;

    public BookShelf(int capacity) {
        books = new Book[capacity];
        numberOfBooks = 0;
    }

    @Override
    public Iterator<Book> iterator() {
        return new BookshelfIterator();
    }

    public void addBook(Book book) {
        if(numberOfBooks< books.length){
            books[numberOfBooks]=book;
            numberOfBooks++;
        }
    }

    private class BookshelfIterator implements Iterator<Book> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex > numberOfBooks;
        }

        @Override
        public Book next() {
            if(!hasNext()){
                throw new NoSuchElementException("No more books on the shelf");
            }
            return books[currentIndex];
        }
    }
}
