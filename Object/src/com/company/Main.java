package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
	Object obj = new Object();

    Person p1 = new Person("Qwerty");
    System.out.println(p1.toString());

    String str = new String("1,2,3");
    Object qwe = str;
    System.out.println(qwe.toString());

    mmm(qwe);
    mmm(p1);

    List list = new ArrayList<>();
    list.add(p1);
    list.add(1);
    list.add("qwerty");
    list.add('a');
    list.get(0);// will return object

        for (Object obj1 : list){
         //   System.out.println(obj1 instanceof String); // found the string in the list

            if(obj1 instanceof String){
                String str1 = (String)obj1;
                System.out.println(str1.toUpperCase()); // prints out only string(qwerty) in upper case
            }
        }

         Object p2 =(Person) list.get(0); //Person p2...
        System.out.println(p2.getClass().getSimpleName());
        Person p3;// Object p3;
        if(p2 instanceof Person) p3 = (Person) p2;
        Person p10 = new Person("glfdljhdf");
        Car car = new Car();

       if(p10 instanceof Car)
           System.out.println("hi");






    }

    public static void mmm(Object object){
  //      object.toUpperCase();
    }
}
