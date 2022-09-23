package com.company;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    // 1.     Дана строка (для простоты можно считать,  слова разделены одним пробелом и строка не содержит знаков препинание и т.д.).
    // Используя стрим, получить map<String, Integer> где ключ – слово, значение – сколько раз это слово встречается в строке
    @Test
    void getMap_String() {
        String str = "orange apple orange pear";
        Map<String, Integer> map = Map.of("orange", 2, "apple", 1, "pear", 1);
        assertEquals(map, Main.KeyWordValueCountWords(str));
    }

    @Test
    void getMap_one_element() {
        String str = "orange";
        Map<String, Integer> map = Map.of("orange", 1);
        assertEquals(map, Main.KeyWordValueCountWords(str));
    }

    @Test
    void getMap_null() {
        String str = null;
        Map<String, Integer> map = Map.of();
        assertEquals(map, Main.KeyWordValueCountWords(str));
    }

    @Test
    void getMap_empty() {
        String str = "";
        Map<String, Integer> map = Map.of();
        assertEquals(map, Main.KeyWordValueCountWords(str));
    }

    //2.     Дан список Person (String firstName, String lastName, int age) используя Stream получить map<String, Integer>,
    // где ключ ФИО в формате Иванов.И, значение возраст.
    @Test
    void getMapKeyIsNameValueIsAge() {

        List<Person> people = List.of(
            new Person("Jack", "Jackson", 25),
            new Person("Peter", "Peterson", 38),
            new Person("John", "Johnson", 19)
    );
        Map<String, Integer> map = Map.of("Jackson J.", 25, "Peterson P.", 38, "Johnson J.", 19);
    assertEquals(map, Main.getMapKeyIsNameValueIsAge(people));
}
@Test
    void MapThreeStudentsFromEachGroup(){

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
Map<String, Double>map = Map.of("Brown", 14.9, "Smith", 15.8, "Wilson", 20.5, "Sanders", 19.0, "Elliot", 18.2, "Müller", 22.2);

assertEquals(map, Main.MapThreeStudentsFromEachGroup(groups));

}


}
