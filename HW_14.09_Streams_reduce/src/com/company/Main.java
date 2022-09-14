package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
	// Дан List<Integer>. Необходимо найти значение элемента максимально близкого к некоторому заданному значению N.


        List<Integer> integerList= List.of(1,5,78,56,93,12);
        System.out.println(findClosestValue(integerList, 105));

        String str = "Jack:room 10; Nick:room 20; Jack:room 1; Mike:room3";
        System.out.println(getTheLastKeyValue(str));
        System.out.println(getTheLastKeyValueStr(str, "Jack"));

    }
    //Option1
    public static Integer findClosestValue(List<Integer>intList, Integer value){
        if(intList==null || value == null) return null;
       return intList.stream()
               .min(Comparator.comparing(i-> Math.abs(i-value))) //returns an Optional if the stream is empty, NPE if the value is null
               .orElseThrow(()-> new NoSuchElementException("Element is not found"));


    }
//Дана строка вида ключ1:значение1;ключ2:значение2;ключ1:значение2;ключ3:значение1 ..... Написать метод, который возвращает
// последнее значение заданного ключа.
//Например: "Jack:room 10;Nick:room 20;Jack:room 1;Mike:room3", "Jack" -> "room 1"
//Если в строке нет заданного ключа возвращается пустая строка.

    //Не уверена, что я правильно поняла задание. Метод озвращает последнее значение ключа, но я не уверена, что это то, что требовалось...

    public static Map<String, String> getTheLastKeyValue(String str){

         Map<String, String> result = Arrays.stream(str.replaceAll("\\s+","").split(";"))
        .map(s->s.split(":"))
        .collect(Collectors.toMap(s-> s[0],s ->s[1], (s1, s2) -> s2));

       return result;
    }

    public static String getTheLastKeyValueStr(String str, String key){
        return getTheLastKeyValue(str).get(key);
    }
}
