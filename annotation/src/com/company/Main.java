package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	Set<Integer> set = new TreeSet<>();
    set.add(0);
    set.add(1);
    set.add(2);
        for (int i = 0; i < set.size(); i++) {
            System.out.println(i);

        }

    Set<String > setString = new HashSet<>();
    setString.add("11");
    setString.add("aa");
    setString.add("ll");

    for(String s : setString){
        System.out.println(s);
    }
        System.out.println("size: " + set.size());

  //  Set<Person>people = new TreeSet<>();
        List<Person> people = new ArrayList<>();
        people.add(new Person("Jack"));
        people.add(new Person("John"));
        people.add(new Person("Nick"));
        people.add(new Person("Jack"));
        Set<Person>people1 = new HashSet<>(people);
        List<Person>list = new ArrayList<>(people1);
        System.out.println(people);
        System.out.println(list);

    }
}
