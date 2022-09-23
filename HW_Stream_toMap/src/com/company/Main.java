package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        String str = "orange apple orange pear";
        System.out.println(KeyWordValueCountWords(str));

        List<Person>people = List.of(
                new Person("Jack", "Jackson", 25),
                new Person("Peter", "Peterson", 38),
                new Person("John", "Johnson", 19)
        );
        System.out.println(getMapKeyIsNameValueIsAge(people));

        List<Student>list1 = List.of(
                new Student("Kate", "Wilson", 20.5),
                 new Student("Ann", "Smith", 15.8),
                new Student("Bradley", "Elliot", 18.2),
                new Student("Alan", "Thompson", 12.4)
        );


        List<Student>list2 = List.of(
                new Student("Jane", "Sanders", 19.0),
                new Student("Nick", "Brown", 14.9),
                new Student("John", "Davis", 10.1),
                new Student("Klaus", "Müller", 22.2)
        );


       List<Group> groups = List.of(new Group("A",list1 ),
                                new Group("B",list2 )
                                );

        System.out.println(groups);

       System.out.println(FromAllGroups(groups));

    }
    // 1.     Дана строка (для простоты можно считать,  слова разделены одним пробелом и строка не содержит знаков препинание и т.д.).
    // Используя стрим, получить map<String, Integer> где ключ – слово, значение – сколько раз это слово встречается в строке.

    public static Map<String, Integer>KeyWordValueCountWords(String str){
        if(str == null || str.isEmpty()) return Map.of();

        Map<String, Integer> result = Arrays.stream(str.toLowerCase().split(" "))
                .collect(Collectors.toMap(word-> word, word->1, (a, b) -> Integer.sum(a, b)));


        return result;
    }
    //2.     Дан список Person (String firstName, String lastName, int age) используя Stream получить map<String, Integer>,
    // где ключ ФИО в формате Иванов.И, значение возраст.

    public static Map<String, Integer> getMapKeyIsNameValueIsAge(List<Person> list){
        return list.stream()
                .collect(Collectors.toMap(s->s.getLastName()+" "+s.getFirstName().substring(0,1)+ ".", Person::getAge));
    }


    //3.     Дан список Group(String title,  Students[] students), Student(String firstName, String lastName, Double rate).
// Используя Stream получить map<String, Double>, где ключ ФИО студента в формате Иванов.И, значение – рейтинг.
// В map должны попасть первые 3 самых успевающих студента из каждой группы. В данной задаче, предполагается, что студентов-однофамильцев нет.


    public static Map<String, Double> FromAllGroups(List<Group>groups){
        return groups.stream()
            .flatMap(gr->gr.getStudents()
                        .stream()
                        .sorted(Comparator.comparing(Student::getRate, Comparator.reverseOrder())).limit(3))
                .collect(Collectors.toMap(Student::getLastName, Student:: getRate));
         //       .collect(Collectors.toMap(s->s.getLastName()+" "+s.getFirstName().substring(0,1)+".", Student:: getRate));


    }


}
