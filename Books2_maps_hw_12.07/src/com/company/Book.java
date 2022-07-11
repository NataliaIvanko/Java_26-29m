package com.company;

import java.util.List;

public class Book {
   List<Author> author;
   private String title;
   private String ISBN;

    public Book(List<Author> author, String title, String ISBN) {
        this.author = author;
        this.title = title;
        this.ISBN = ISBN;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getISBN() {
        return ISBN;
    }

    @Override
    public String toString() {
        return author +
                " " + title + " "+ ISBN ;
    }
}
