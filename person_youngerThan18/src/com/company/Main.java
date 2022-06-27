package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Person> people = Arrays.asList( // I can change one person to another one. List.of - no changes are possible
                new Person("a", 10),
                new Person("b", 10),
                new Person("c", 10),
                new Person("d", 20),
                new Person("e", 30),
                new Person("f", 15),
                new Person("g", 25));

        List<Person> list = new ArrayList<>(people);
        removeChildren(list);
        System.out.println(list);

        ListIterator<Person> listIter = list.listIterator(list.size()-1);
        while(listIter.hasPrevious()){
            System.out.println(listIter.previous());
        }


/*
        list.remove(2);
        System.out.println(people);
        System.out.println(list);

 */
    }

    public static void removeChildren(List<Person> list) {
        /*
        for(Person p : list){
            if(p.getAge()<18){
                list.remove(p);


        for (int i = list.size()-1; i>=0; i--) {
            if (list.get(i).getAge() < 18) {
                list.remove(i);

         */

        Iterator<Person> it = list.iterator();
        while (it.hasNext()) {
           if (it.next().getAge() < 18) it.remove();
        }
    }
}


