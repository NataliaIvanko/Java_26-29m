package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,8,45,12, 12);
        List<String> list2 = Arrays.asList("cat", "dog", "lama", "dog", "tiger");

        System.out.println(removeDuplicates(list1));
        System.out.println(removeDuplicates(list2));

    }
 //   Реализовать метод который из листа любого типа удаляет дубликаты, при этом сохраняя порядок элементов.
    public static  <T> List<T> removeDuplicates(List<T> input) {
        if (input == null || input.isEmpty()) return Collections.emptyList();
        Set<T> result = new TreeSet<>(input);
        return new ArrayList<>(result);
    }
}
