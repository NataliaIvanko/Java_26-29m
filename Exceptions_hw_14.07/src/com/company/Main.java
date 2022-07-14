package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	//Есть List<String>. Все элементы в нем должны быть строки-целые числа вида “231”, но некоторые данные повреждены (например, содержат символы).
        // Необходимо преобразовать данный список в List<Integer>.
        // При этом вывести на экран детализированный список «ошибок» т.е. в каких ячейках и
        // какие значения не были преобразованы.

        List<String> list =  Arrays.asList("234", "564", "5&6");
        System.out.println(catchException(list));
        System.out.println(getErrors(list));
        int[] newArr = new int[10];
        int[][] newArr1 = new int[5][5];

        System.out.println(getArray(newArr1));

    }
    public static List<String> catchException(List<String> list){
        List<Integer> correctDataList = new ArrayList<>();
        List<String> errorsList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            try{
                correctDataList.add(Integer.parseInt(list.get(i)));
            }catch(NumberFormatException e){
                errorsList.add(list.get(i)+ " is a wrong type");
            }
        }
        return errorsList;
    }
    public static Map<Integer,String> getErrors(List<String> list) {
        Map<Integer, String> errorsMap = new HashMap<>();
        if (list == null) return errorsMap;

        for (int i = 0; i < list.size(); i++) {
            try {
                Integer.parseInt(list.get(i));
            }catch (NumberFormatException e){
                errorsMap.put(i, list.get(i));
            }
        }

        return errorsMap;
    }
    //2. Допустим, Ваш метод должен получить массив int размером 10x10 элементов.
    // Необходимо, что бы ваш метод бросал IllegalArgumentException если размер переданного массива
    // некорректен или вместо массива пришел null.

        public static boolean getArray (int[][] array) throws IllegalArgumentException {
        if (array == null){
            throw new IllegalArgumentException("The array is empty");
        }

        if (array.length != 10) {
            throw new IllegalArgumentException("Height value is incorrect");
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 10) {
                throw new IllegalArgumentException("Width value is incorrect");
            }
        }
        return true;
    }
}
