package com.company;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMain {
// Дан список строк вида "a:11", "b:22", "a:13".... Необходимо получить Map<String, List<Integer>> где ключ это символ,
    // а значение - список цифровых значений соответствующих символу.
    //Пример:
    //("a:11", "b:22", "a:13", "c:20", "a:10") -> {a=[11, 13, 10], b=[22], c=[20]}
    @Test
    void getMap_List(){
        List<String> list = List.of("a:11", "b:22", "a:13", "c:20", "a:10");
        Map<String, List<Integer>> map = Map.of("a", List.of(11,13,10), "b", List.of(22), "c", List.of(20));
        assertEquals(map, Main.getMap(list));
    }
    @Test
    void getMap_one_element() {
        List<String> list = List.of("a:11");
        Map<String, List<Integer>> map = Map.of("a", List.of(11));
        assertEquals(map, Main.getMap(list));
    }
    @Test
    void getMap_emptyList() {
        List<String> list = List.of();
        Map<String, List<Integer>> map = Map.of();
        assertEquals(map, Main.getMap(list));
    }
    //Дан список выплат в виде списка строк: "Jack:1110.00", "Nick:220.50", "Jack:1300.20"....
    // Необходимо получить Map<String, Double> где ключ это имя,
    // а значение - сумма выплат.
    //Пример:
    //("Jack:1110.00", "Nick:220.50", "Jack:1300.20") -> {Nick=220.5, Jack=2410.2}
    @Test
    void getMapSumOfElements_NormalList(){
        List<String> list1 = List.of("Jack:1110.00", "Nick:220.50", "Jack:1300.20");
        Map<String, Double> map = Map.of("Nick", 220.5, "Jack", 2410.2);
        assertEquals(map, Main.getMapSumOfPayments(list1));
    }
    @Test
    void getMapSumOfElements_list_one_element() {
        List<String> list1 = List.of("Jack:1110.00");
        Map<String, Double> map = Map.of("Jack", 1110.0);
        assertEquals(map, Main.getMapSumOfPayments(list1));
    }
    @Test
    void getMapSumOfElements_emptyList() {
        List<String> list1 = List.of();
        Map<String, Double> map = Map.of();
        assertEquals(map, Main.getMapSumOfPayments(list1));
    }

}
