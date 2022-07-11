package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	//
        //3)    Предположим, что дан список Book, но в отличие от предыдущей задачи Author – класс {String fName, String lName}
        // и книга более сложный объект, у которого есть список авторов, название и ISBN (International Standard Book Number)
        // т.е. {String title, List<Author> authors, String ISBN}. Необходимо сформировать map<Author, List<Book>>,
        // где ключ - автор, а значение список его книг.
        // Естественно, если у книги несколько авторов, то книга должна отразиться в списке книг всех авторов данной книги.

        List<Author> authors = new ArrayList<>();
        Author a1 = new Author("A1", "A11");
        Author a2 = new Author("A2", "A22");
        Author a3 = new Author("A3", "A33");
        Author a4 = new Author("A4", "A44");


        List<Author>la1 = Arrays.asList(a1, a2);
        List<Author>la2 = Arrays.asList(a2, a3);
        List<Author>la3 = Arrays.asList(a3, a4);
        List<Author>la4 = Arrays.asList(a4);


        Book b1 = new Book(la1,  "A Christmas Carol", "123");
        Book b2 = new Book(la2,  "Dombey and Son", "321");
        Book b3 = new Book(la3,  "Some Time Never", "456");
        Book b4 = new Book(la4,  "Fantastic Mr Fox", "654");

        List<Book>bookList = Arrays.asList(b1, b2, b3, b4);

        System.out.println(mapBooks(bookList));

    }
    public static Map<Author, List<String>> mapBooks(List<Book>books) {

        Map<Author, List<String>> result = new HashMap<>();
        List<String> tmp = new ArrayList<>();
        for (Book b : books) {
            List<Author> authorList = new ArrayList<>();
            authorList = b.getAuthor();
            for (Author a : authorList) {
                tmp = result.get(a);
                if (tmp == null) tmp = new ArrayList<>();
                tmp.add(b.getTitle());
                result.put(a, tmp);
            }
        }
        return result;
        }


}
