package com.company;

public class Book1 {
    private String title;

    public Book1(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return  title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book1)) return false;

        Book1 book1 = (Book1) o;

        return title != null ? title.equals(book1.title) : book1.title == null;
    }

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }
}
