package com.company;

import java.sql.ClientInfoStatus;
import java.util.*;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {


        List<Integer> ints = Arrays.asList(6, 6, 8, 9, 14, 15, 15, 15, 20);

        System.out.println(removeDuplicates(ints));

        List<Boolean> list = Arrays.asList(true, false, false, true, true, true, false);
        System.out.println(theLongestSubsequence(list));

        System.out.println(numberOfOccurrences(ints));
        System.out.println(numberOfOccurrences1(ints));

        String str1 = "New York Times";
        int length1 = str1.length();
        System.out.println(length1);
        String str2 = "monkeys write ";
        int length2 = str2.length();
        System.out.println(length2);
        System.out.println(isAnangram(str1, str2));
        System.out.println(isAnangram1(str1, str2));

        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 2);
        map.put('c', 3);
        map.put('k', 1);
        map.put(' ', 2);
        map.put('b', 4);
        System.out.println(getALetterNTimes(map));


    }
    // 1.  	Дан отсортированный лист Integer. Необходимо удалить из него все дубликаты.
    //{6,6,8,9,14,15,15,15,20} -> {6,8,9,14,15,20}

    public static List<Integer> removeDuplicates(List<Integer> ints) {
        if (ints == null || ints.isEmpty()) return ints;
        Set<Integer> result = new TreeSet<>(ints);
        return new ArrayList<>(result);
    }
    // 2.  	Дан в котором записаны результаты подбрасывания монетки (true\false соответственно орел\решка)
    //   Необходимо вычислить самую длинную последовательность «орлов» .{true,true,false,true,false,true,true,true,false}->3

    public static int theLongestSubsequence(List<Boolean> list) {

        int counter = 0;
        int maxCount = 1;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals(list.get(i - 1))) {
                counter++;
                if (counter > maxCount) {
                    maxCount = counter;
                }
            } else {
                counter = 1;
            }
        }
        return maxCount;
    }

    //3.  	Дан список Integer, каждое значение число от 1 до 12 (результат броска двух игральных костей).
    // В результате работы программы, необходимо сформировать отчет, сколько раз выпало каждое ччисло.
    // Вывести результат в порядке возрастания.
    //{6,6,1,4,9,12,11,9,1,9} –{1->2, 4->1, 6->2, 9->3, 11->1, 12->1}

    public static Map<Integer, Integer> numberOfOccurrences(List<Integer> ints) {
        Map<Integer, Integer> counter = new TreeMap<>();
        for (Integer currentNum : ints) {
            counter.put(currentNum, counter.get(currentNum) != null ? counter.get(currentNum) + 1 : 1);
        }
        return counter;
    }

    public static Map<Integer, Integer> numberOfOccurrences1(List<Integer> ints) {
        Map<Integer, Integer> counter = new HashMap<>();
        if (ints == null || ints.isEmpty()) return counter;
        for (Integer currentNum : ints) {
            if (counter.containsKey(currentNum)) {
                counter.put(currentNum, counter.get(currentNum) + 1);
            } else {
                counter.put(currentNum, 1);
            }
        }
        Map<Integer, Integer> sortedMap = new TreeMap<Integer, Integer>(counter);
        return sortedMap;
    }
    //4.  	Анагра́мма — строка, составленная путем перестановки букв исходной строки,
    // например “ABB CAA“ - “BA BCAA“ -> “CBA BAA“ …… В задаче дано 2 строки и символов латинского алфавита и пробелов,
    // нужно определить, являются ли они анаграммами.
    // Если знаете, предложите несколько алгоритмов\подходов к решению данной задачи.

    public static boolean isAnangram(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length())
            return false;

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        str1 = str1.replaceAll("\\s", "");
        str2 = str2.replaceAll("\\s", "");
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);
        return Arrays.equals(ch1, ch2);
    }

    // Second Solution
    public static boolean isAnangram1(String str1, String str2) {
        Map<Character, Integer> map = new HashMap<>();
        if (str1 == null || str2 == null || str1.length() != str2.length())
            return false;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        str1 = str1.replaceAll("\\s", "");
        str2 = str2.replaceAll("\\s", "");
        char[] string1 = str1.toCharArray();
        char[] string2 = str2.toCharArray();

        for (char ch : string1) {
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }

        }
        for (char ch : string2) {
            if (!map.containsKey(ch)) {
                return false;
            } else {
                map.put(ch, map.get(ch) - 1);
            }
        }
        for (int occurrences : map.values()) {
            if (occurrences != 0) {
                return false;
            }
        }
        return true;
    }
    //5.  	Дана  map <Character, Integer>. Необходимо сформировать случайную строку, где соответствующая буква будет встречаться
    // заданное количество  раз.
    //{A->2, b->1, k->2, c->3, ‘ ‘->2 } -> “ck cca k”

    public static String getALetterNTimes(Map<Character, Integer> map){
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character, Integer> entries : map.entrySet()){
        for (int i = 0; i < entries.getValue(); i++) {
            sb.append(entries.getKey());

        }
        }
            String str = sb.toString();

            List<String>characters = Arrays.asList(str.split(""));
            String shuffledString = "";
            Collections.shuffle(characters);
            for(String character : characters){
                shuffledString+=character;

        }
        return shuffledString;

    }
}
