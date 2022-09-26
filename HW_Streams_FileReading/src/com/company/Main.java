package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        //1
        List<String> list = List.of("apple", "banana", "lemon", "orange", "apple");
        System.out.println(getMapKeyIsTheFirstWordLetter(list));

        //2
        List<String> list1 = List.of("Linux", "Windows", "Mac");
        System.out.println(mergeStrings(list1));

        //3
        Path path = Paths.get("C:\\Java\\Java_26-29m\\HW_Streams_FileReading\\src\\com\\company\\LinesToMerge.txt");
        System.out.println(mergeStrings(path));

        //4
        String contents = Files.readString(Paths.get("C:\\Java\\Java_26-29m\\HW_Streams_FileReading\\src\\com\\company\\WarAndPeace.txt"));
        System.out.println(countWords(contents));
        System.out.println(countUniqueWords(contents));

        //4
        System.out.println(countWords1(contents));

    }
    // 1. "apple", "banana", "lemon", "orange" - даны такие слова
    //преобразовать стрим из строк в мапу, причём ключом сделать первую букву соответствующего слова
    //{a=apple, b=banana, l=lemon, o=orange}

    public static Map<String, String> getMapKeyIsTheFirstWordLetter(List<String> list) {
        if (list == null || list.isEmpty()) return Map.of();
        return list.stream()
                .collect(Collectors.toMap(word -> word.substring(0, 1), word -> word, (w1, w2) -> w2));

    }

    //2. "Linux", "Windows", "Mac" - даны такие слова
    //Объединение нескольких строк в одну
    public static String mergeStrings(List<String> list) {
        return list.stream().collect(Collectors.joining(", "));
    }
    //3.Path path = Paths.get(путьдофайла);
    //Прочитать все строки текстового файла и объединить их в одну строку

    public static String mergeStrings(Path path) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(path)));

            String line = reader.readLine(); //readLine returns null when there are no more lines
            while (line != null) {
                sb.append(line + " ");
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();

    }
//String contents = new String(Files.readAllBytes(Paths.get("src/main/java/WarAndPease.txt")), StandardCharsets.UTF_8);
// - "src/main/java/WarAndPease.txt это ссылка на какой либо текст.
//
//
//Необходимо прости стримом по тексту написать метод который считает количество уникальных слов
//long count = words.stream().distinct().count();
//И количество повторений
//long countWithRepeat =тут тоже будет стрим

/*
//тут обработать String contents
*/

//System.out.println("Слов всего " + countWithRepeat);
//System.out.println("Уникальных слов  " + count);

    //P|S Используйте так же регулярные выражения. Это задание было на собеседование в EPAM
    public static long countUniqueWords(String str) {
        long count = Stream.of(str.split("\\s+|(?<=[a-z])(?=[a-z])"))
                .distinct()
                .count();
        return count;
    }

    public static long countWords(String str) {
        long count = Stream.of(str.split("\\s+|(?<=[a-z])(?=[a-z])"))
                .count();
        return count;
    }


    //5.Есть стринга
    //Нужно вывести каждое слово и количество его повторений одним стримом
    public static Map<String, Integer> countWords1(String str) {
        Map<String, Integer> map = Stream.of(str.split("\\s+|(?<=[a-z])(?=[a-z])"))
                .collect(Collectors.toMap(s -> s, s -> 1, (s1, s2) -> s1 + 1));
        return map;
    }
}


