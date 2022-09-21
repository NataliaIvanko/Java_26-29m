package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Student s1 = new Student("Sergey", "m", 22, 3, 8.3);
        Student s2 = new Student("Nik", "m", 28, 2, 7.4);
        Student s3 = new Student("Elena", "w", 32, 1, 9.0);
        Student s4 = new Student("Petr", "m", 30, 4, 6.0);
        Student s5 = new Student("Marya", "w", 21, 5, 7.7);

        List<Student>studentList = List.of(s1,s2,s3,s4,s5);

        List<Student>studentList1 = List.of(s1, s2, s3);
        List<Student>studentList2 = List.of(s4, s5);

        Faculty f1 = new Faculty("C++", studentList1);
        Faculty f2 = new Faculty("Java", studentList2);
/*
        f1.add(s1);
        f1.addStOnF(s2);
        f1.addStOnF(s3);
        f2.addStOnF(s4);
        f2.addStOnF(s5);*/

        List <Faculty>facultyList = new ArrayList<>();
        facultyList.add(f1);
        facultyList.add(f2);
        System.out.println(facultyList);

        studentsOlderThan22(studentList);
        studentsOlderThan22_1(studentList);
        studentsNames(facultyList);


        // Почему код не отработает?
        Stream str1 = Stream.of(1, 23, 24, 45, 2, 4, 4, 6, 77);
        System.out.println(str1.count());
      //  System.out.println(str1.distinct().count());
        /*
       Стрим может быть использован один раз. После вызова терминального оператора count() стрим str1 закрылся, при попытке дальнейших операций возникнет IllegalStateException.
        Если мы опять хотим его использовать, то можно использовать функциональный интерфейс Supplier.
        У Supplier есть абстрактный метод get(), вызвав который мы получим новый  Stream object, мы можем выполнять дальнейшие операции

         */
        Supplier<Stream<Integer>> streamSupplier = () -> Stream.of(1, 23, 24, 45, 2, 4, 4, 6, 77);

        System.out.println(streamSupplier.get().count());
        System.out.println(streamSupplier.get().distinct().count());



    }
    //1. отфильтровать студентов age>22 а вывести на экран только одного [use  limit ]
    public static void studentsOlderThan22(List<Student>studentList){
                 studentList.stream()
                .filter(s-> s.getAge()>22)
                         .limit(1)
                .forEach(s-> System.out.println(s));
    }

    //2. отфильтровать студентов age>22 , вывести на экран пропустить первого [есть метод для пропуска ]
    public static void studentsOlderThan22_1(List<Student>studentList) {
        studentList.stream()
                .filter(s -> s.getAge() > 22)
                .skip(1)
                .forEach(System.out::println);
    }

    //3.Вывести имена всех студентов на всех факультетах
    public static void studentsNames(List<Faculty>facultyList){
        facultyList.stream()
                .flatMap(f->f.getStudents().stream()
                        .map(s->s.getName()))
                .forEach(System.out::print);
    }

}
