package com.company;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.List.of;

public class Main {

    public static void main(String[] args) {

        List<String> list = List.of("a:11", "b:22", "a:13", "c:20", "a:10");
        System.out.println(getMap(list));

        List<String> list1 = List.of("Jack:1110.00", "Nick:220.50", "Jack:1300.20");
        System.out.println(getMapSumOfPayments(list1));


    }
    // Дан список строк вида "a:11", "b:22", "a:13".... Необходимо получить Map<String, List<Integer>> где ключ это символ,
    // а значение - список цифровых значений соответствующих символу.
    //Пример:
    //("a:11", "b:22", "a:13", "c:20", "a:10") -> {a=[11, 13, 10], b=[22], c=[20]}

    public static Map<String, List<Integer>> getMap(List<String> list) {
        Map<String, List<Integer>> result = list.stream()
                .collect(Collectors.groupingBy(s -> s.split(":")[0],
                        Collectors.mapping(s -> Integer.parseInt(s.split(":")[1]), Collectors.toList())));

        return result;
    }
    //Дан список выплат в виде списка строк: "Jack:1110.00", "Nick:220.50", "Jack:1300.20"....
    // Необходимо получить Map<String, Double> где ключ это имя,
    // а значение - сумма выплат.
    //Пример:
    //("Jack:1110.00", "Nick:220.50", "Jack:1300.20") -> {Nick=220.5, Jack=2410.2}

    public static Map<String, Double> getMapSumOfPayments(List<String> list) {

       return list.stream()
                .collect(Collectors.groupingBy(s -> s.split(":")[0],
                        Collectors.summingDouble(s -> Double.parseDouble(s.split(":")[1]))));



    }
}
