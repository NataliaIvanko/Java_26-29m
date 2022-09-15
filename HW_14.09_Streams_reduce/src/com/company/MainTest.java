package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MainTest {
    List<Integer> input = List.of(2, 5, 8);
    @Test
    void getClosestElement_Normal() {

        Assertions.assertEquals(5, Main.findClosestValue(input, 4));
    }
    @Test
    void getClosestElement_NormalEqualNumber() {
        Assertions.assertEquals(5, Main.findClosestValue(input, 5));
    }
    @Test
    void getClosestElement_NegativeNumber() {
        Assertions.assertEquals(2, Main.findClosestValue(input, -2));
    }
    @Test
    void getClosestElement_EmptyList1() {
        List<Integer> input = new ArrayList<>();
        Assertions.assertThrows(NoSuchElementException.class, () -> Main.findClosestValue(input, 5));
    }
    @Test
    void getClosestElement_EmptyList() {
        List<Integer> input = new ArrayList<>();
        Assertions.assertEquals( 0, Main.findClosestValue(input, 5));
    }
    @Test
    void getClosestElement_Null_N() {
        Assertions.assertEquals(null, Main.findClosestValue(input, null));
    }
}
