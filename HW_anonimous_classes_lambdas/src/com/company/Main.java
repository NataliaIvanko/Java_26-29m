package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// В программе задан список Person{ String fName, String lName, String email, String phone, Address address}.
        // Address{String postcode, String city, String street, String house}
        //Реализовать следующие функции:
        //   	                   	-получить список всех ФИО
        //           	   	    	-получить список всех e-mail
        //   	                   	-получить список всех телефонов
        //   	                   	-получить список всех адресов в виде строки адреса
        //Естественно, все вышеперечисленные функции может и должен реализовать один метод,
        // в который в качестве параметра должен приходить список Person и реализация необходимого способа обработки.
        // Ограничения: не использовать стандартные Java интерфейсы, все необходимые классы и интерфейсы описывать
        // и реализовывать самостоятельно. Не использовать stream.


        //Task 1
        Person p1 = new Person("Jack", "Davis", "jack@gmailcom", "015789236", new Address("10115",
                "Berlin", "Wttelsbacherstr", "51"));
        Person p2 = new Person("Jane", "Mitchell", "jane@gmailcom", "017852369", new Address("10117",
                "Berlin", "Krausenstr", "82"));

        List<Person>personList = new ArrayList<>();
        personList.add(p1);
        personList.add(p2);

        System.out.println(getTheList(personList, p -> String.valueOf(p.getAddress())));


        // Task 2
       List<String>listStrings = Arrays.asList("Hello", "everyone", "how", "is", "it", "going", "?");

        System.out.println(createNewList(listStrings, s ->s.length()));

       MyFunction<Person, Object> f2 = p->p.getAddress();
       System.out.println(createNewList(personList, f2));


    }

    public static List<String> getTheList (List<Person> list, PersonFunction function){

        List<String> res = new ArrayList<>();
       list.forEach(person ->res.add(function.apply(person)));

    return res;
    }


    // Решить задачу №1 в общем виде: т.е. есть список объектов типа A необходимо получить список объектов типа B.
    // Проверить, получив из листа Person лист объектов Address, из листа String лист Integer с длинами строк.

    public static <A,B> List<B> createNewList(List<? extends A> list, MyFunction<A, ? extends  B> function){
        List<B> res = new ArrayList<>();

        for(A a : list){
            res.add(function.apply(a));
        }
        return res;
    }

}
