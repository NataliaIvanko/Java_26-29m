package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
       Author a1 = new Author("Stephen", "King");
        Author a2 = new Author("Anna", "Starobinets");

        Book b1 = new Book("Needful things", a1);
        Book b2 = new Book("Zverskiy detektiv", a2);
        Book b3 = new Book("Zverskie skazki", a2);

        List<Book> bookList = new ArrayList<>();
        bookList.add(b1);
        bookList.add(b2);
        bookList.add(b3);
        System.out.println(getAuthors(bookList));

        List<Users> users = new ArrayList<>();
        users.add(new Users("Kate Williams", "123@gmail.com"));
        users.add(new Users("John Richardson", "ght@yandex.ru"));
         users.add(new Users("Alison Montgomery", "uoprgä@gmail.com"));
         users.add(new Users("Alison Montgomery", "uoprgä@gmail.com"));

        System.out.println(nonUniqueElements(users));

        List<Users1>list1 = new ArrayList<>();
        list1.add(new Users1("Kate", "Williams","123@gmail.com"));
        list1.add(new Users1("Kai", "Janssen","456@gmail.com"));
        list1.add(new Users1("John", "Smith","789@gmail.com"));

        List<Users1>list2 = new ArrayList<>();
        list2.add(new Users1("Josh", "Davis","tzu@gmail.com"));
        list2.add(new Users1("Mary", "Watson","ghjku@gmail.com"));
        list2.add(new Users1("Emma", "Anderson","tzu@gmail.com"));

        List<Users1>list3 = new ArrayList<>();
        list3.add(new Users1("Josh", "Davis","tzu@gmail.com"));
        list3.add(new Users1("Amelie", "Thompson","yldkgl-y@gmail.com"));
        System.out.println(findEmails(list1, list2, list3));

    }
    public static List<Author> getAuthors(List<Book> bookList){
        Set<Author>authors = new HashSet<>();
        for(Book b: bookList){
            authors.add(b.getAuthor());
        }
        List<Author> authorList = new ArrayList<>(authors);
        return authorList;

    }
    public static boolean nonUniqueElements(List<Users>usersList){
        Set<Users> duplicates = new HashSet<>(usersList);
        /*
       for(Users u : usersList){
          if(!duplicates.contains(u)){
              duplicates.add(u);
          }
       }*/
        if (duplicates.size()< usersList.size()){
            return true;
        }
        return false;
    }
    public static Set<String>findEmails(List<Users1>list1, List<Users1>list2, List<Users1>list3){
        List<Users1>resList = new ArrayList<>();
        resList.addAll(list1);
        resList.addAll(list2);
        resList.addAll(list3);
        Set<String> result = new HashSet<>();

        for(Users1 res: resList){
               result.add(res.getEmail());
        }

        return result;
    }
}
