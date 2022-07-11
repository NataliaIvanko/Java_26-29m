package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //2)     Дан список Book{String author, String title}.
        // Необходимо сформировать map<String, List<String>> ,где ключом будет автор, а значением - список книг данного автора.

        Map<String, ArrayList<String>>mapBooks = new HashMap<>();
        List<Books> books = new ArrayList<>();
       books.add(new Books("Anna Starobinets","Zverskiy detektiv"));
        books.add(new Books("Anna Starobinets","Zverskie skazki"));
        books.add(new Books("Fiodor Dostoevskiy","Idiot"));
        books.add(new Books("Fiodor Dostoevskiy","Idiot2"));
        System.out.println(mapBooks(books));

       // 4)      Предположим, дан список поступивших в библиотеку книг.
        // Если пришло несколько экземпляров одной и той же книг,
        // в списке присутствует соответствующее количество одинаковых записей.
        // Необходимо сформировать Map<Book, Integer>, где ключ это книга,
        // значение, сколько раз она встречается в списке, т.е. сколько пришло экземпляров.

        List<Book1>listOfBooks = new ArrayList<>();
        listOfBooks.add(new Book1("Nevewhere"));
        listOfBooks.add(new Book1("Nevewhere"));
        listOfBooks.add(new Book1("Coraline"));
        listOfBooks.add(new Book1("Crime and Punishment"));
        listOfBooks.add(new Book1("Crime and Punishment"));

        System.out.println(countBooks(listOfBooks));
        System.out.println(countBooks1(listOfBooks));




    }

    //2)     Дан список Book{String author, String title}.
    // Необходимо сформировать map<String, List<String>> , где ключом будет автор, а значением - список книг данного автора.
    public static Map<String, List<String>>mapBooks(List<Books>books){

        Map<String, List<String>>result = new HashMap<>();
        List<String>tmp = new ArrayList<>();
        for(Books b : books){
               tmp = result.get(b.getAuthor());
                if(tmp == null) tmp = new ArrayList<>();
                tmp.add(b.getTitle());
                result.put(b.getAuthor(),tmp);
         }
        return result;
    }
    // 4)      Предположим, дан список поступивших в библиотеку книг.
    // Если пришло несколько экземпляров одной и той же книг,
    // в списке присутствует соответствующее количество одинаковых записей.
    // Необходимо сформировать Map<Book, Integer>, где ключ это книга,
    // значение, сколько раз она встречается в списке, т.е. сколько пришло экземпляров.

    public static Map<Book1, Integer>countBooks(List<Book1> listOfBooks){
        Map<Book1, Integer>result = new HashMap<>();

        for(Book1 b: listOfBooks){
            result.put(b, result.getOrDefault(b, 0)+1);
        }
        return result;
    }

    public static Map<Book1, Integer>countBooks1(List<Book1> listOfBooks){
        Map<Book1, Integer>counter = new HashMap<>();
        for(Book1 b: listOfBooks) {
            if (counter.containsKey(b)) {
                counter.put(b, counter.get(b) + 1);
            } else {
                counter.put(b, 1);
            }
        }
            return counter;
        }
}
