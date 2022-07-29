package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("a", "b", "c", "d");
        List<String> list2 = Arrays.asList("c", "d", "a", "b");
        System.out.println(isCyclic(list1, list2));
        Map<Character, Set<String>> map = new HashMap<>();
        map.put('a', new HashSet<>(List.of("apple", "and", "array")));
        map.put('b', new HashSet<>(List.of("banana", "building", "bear", "angel")));
        System.out.println(map);
        System.out.println(correctedMistakes(map));

    }
    //  6.  	Дана  map <Character, Set<String>> где значение – список строк начинающихся на букву, которая является ключом.
    //  Увы, исходный map содержи ошибки. Несколько строк записаны в неправильные ключи. Написать метод, который скорректирует map.

    public static Map<Character, Set<String>> correctedMistakes(Map<Character, Set<String>> map) {

        for (Map.Entry<Character, Set<String>> entries : map.entrySet()) {
            Set<String> setCurrent = entries.getValue();
            Iterator<String> it = setCurrent.iterator();
            while (it.hasNext()) {
                String s1 = it.next();
                //   for (String s : entries.getValue()) {
                if (entries.getKey() != s1.charAt(0)) {

                    Set<String> setTemp = new HashSet<>();

                    setTemp = map.get(s1.charAt(0));
                    setTemp.add(s1);
                    map.put(s1.charAt(0), setTemp);
                    it.remove();
                }
            }
        }
        return map;
    }


    //7.  	 Есть два списка с буквами. Определить, является ли один список циклическойверсией другого.
    // Например, для списков {a, b, c, d} и {c, d, a, b} результат будет true, а для {d, e, f} и {d, f, e} - false.

    public static boolean isCyclic(List<String> list1, List<String> list2) {
        if (list1.size() != list2.size()) return false;
        Queue<String> queue1 = new LinkedList<>(list1);
        Queue<String> queue2 = new LinkedList<>(list2);

        for (int i = 0; i < list2.size(); i++) {
            String str = queue2.peek();
            queue2.remove();
            queue2.add(str);

            if (queue2.equals(queue1)) {
                return true;
            }
        }
        return false;
    }

}
