package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<String, ArrayList<String>>mapBooks = new HashMap<>();
        List<Books> books = new ArrayList<>();
       books.add(new Books("Anna Starobinets","Zverskiy detektiv"));
        books.add(new Books("Anna Starobinets","Zverskie skazki"));
        books.add(new Books("Fiodor Dostoevskiy","Idiot"));
        books.add(new Books("Fiodor Dostoevskiy","Idiot2"));
        System.out.println(mapBooks(books));




    }
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
}
