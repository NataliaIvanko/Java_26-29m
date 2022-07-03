package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	List<String> strList = new ArrayList<>();
    strList.add("Apple");
    strList.add("Mango and Passionfruit");
    strList.add("Sweet melon");
    strList.add("citrus fruit");
    strList.add("Peach");
    strList.add("Apple");
    strList.add("citrus fruit");
        System.out.println(uniqueTwoAndMoreWords(strList));

    List<Student>students = new ArrayList<>();
    students.add(new Student("Ann Williams", 5));
    students.add(new Student("John Richardson", 8));
    students.add(new Student("Alison Montgomery", 7));
    List<Student>students1 = new ArrayList<>();
    students1.add(new Student("Alison Montgomery", 7));
    students1.add(new Student("Kate Williams", 3));
    students1.add(new Student("John Smith", 10));
    List<Student>students2 = new ArrayList<>();
    students2.add(new Student("Kai Janssen", 0));
    students2.add(new Student("John Smith", 10));
    students2.add(new Student("Kate Williams", 3));


        List<Group> listOfGroups = new ArrayList<>();
        listOfGroups.add(new Group("A",students));
        listOfGroups.add(new Group("B",students1));
        listOfGroups.add(new Group("C",students2));

        System.out.println(threeStudents(listOfGroups));



    }

    public static List<String>uniqueTwoAndMoreWords(List<String>strList){
     Set<String>strSet = new HashSet<>(strList);
     List<String>newList = new ArrayList<>();
     Iterator<String> it = strSet.iterator();

     while(it.hasNext()){
         String s = it.next();
            if(s.contains(" ")){
               newList.add(s);
        }
      }
     return newList;
    }

    public static List<Student> threeStudents(List<Group> listOfGroups){

        List<Student> newList = new ArrayList<>();

        for(Group g : listOfGroups){
            newList.addAll(g.student);

        }

        List<Student>resultList = new ArrayList<>();

        TreeSet<Student> newSet = new TreeSet<>(newList);
        resultList.add(newSet.pollLast());
        resultList.add(newSet.pollLast());
        resultList.add(newSet.pollLast());

/*
        int n = newSet.size()-2;
        Iterator<Student>it = newSet.iterator();
        while(n < newSet.size()-2){
            newSet.pollFirst();
            n++;
        }
*/
return resultList;

    }
}
