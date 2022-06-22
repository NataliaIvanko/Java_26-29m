package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// Дано список Students{String name, List}, необходимо сформировать список StudentGPA {name, gpa}
    Students st1 = new Students("Jack", Arrays.asList(4,2,4,5,3,5,2,3));
    Students st2 = new Students("John", Arrays.asList(4,2,5,2,3));
    Students st3 = new Students("Anna", Arrays.asList(5,5,5,4,5,4,5));
  //  StudentGPA stGPA = new StudentGPA("qwer", 3.4)
  //  System.out.println(st1);

        List<Students> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);

        System.out.println(transform(students));
   }

   public static List<StudentGPA> transform(List<Students>students){
    List<StudentGPA>result = new ArrayList<>();
    if(students==null || students.isEmpty()) return result;

       for(Students s: students){
           result.add(new StudentGPA(s.getName(), s.getGPA()));
       }
       return result;
   }
}
