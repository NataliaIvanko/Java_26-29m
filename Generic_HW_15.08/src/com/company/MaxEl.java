package com.company;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

// Реализовать обобщенный метод поиска максимального элемента в любом допустимом листе.

public class MaxEl {


    public static <T extends Comparable<? super T>> T getMaxElement(Collection<T> collection){
        if(collection == null || collection.isEmpty()) return null;
        T maxEl = null;
        Iterator<T> it = collection.iterator();
        while(it.hasNext()){
            T temp = it.next();
            if(maxEl == null || temp.compareTo(maxEl) >0){
                maxEl = temp;
            }
        }
        return maxEl;
}

        public static void main(String[] args) {

        List<Integer> list1 = Arrays.asList(1,8,45,12);
        List<String> list2 = Arrays.asList("cat", "dog", "lama", "tiger");


        System.out.println(getMaxElement(list1));
        System.out.println(getMaxElement(list2));
    }
}
