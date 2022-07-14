package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        //1)    Дана Map<String, String>, если в ней есть ключ ‘a’ и ‘b’,
        // то нужно  создать новый ключ ‘ab’ с суммой значений от ключей a и b.


        Map<String, String> mapStr = new HashMap<>();
        mapStr.put("a", "Hi");
        mapStr.put("b", "There");
        mapStr.put("c", "What");
        mapStr.put("d", "are");
        mapStr.put("e", "you");
        mapStr.put("f", "doing");
        System.out.println(concatAB(mapStr));


        addSummaryValue(mapStr, List.of("a", "b", "c"));
        System.out.println(mapStr);

    }
    public static Map<String, String>concatAB(Map<String, String>mapStr){
        if(mapStr != null && !mapStr.isEmpty()&& mapStr.containsKey("a") && mapStr.containsKey("b")){
            Map<String, String>mapAB = new HashMap<>();
            mapAB.put("ab", mapStr.get("a").concat(mapStr.get("b")));
            return mapAB;
        }
        return mapStr;
    }
    public static void concatAB1(Map<String, String>mapStr, String a, String b) {
        if (mapStr != null && !mapStr.isEmpty() && mapStr.containsKey("a") && mapStr.containsKey("b")) {

            mapStr.put(a+b, mapStr.get(a).concat(mapStr.get(b)));

        }

    }
    public static void addSummaryValue(Map<String, String>map, List<String> keys){
        if(map != null && !map.isEmpty()&& map.keySet().containsAll(keys)){
            String resValue = "";
            String resKey = "";
            for(String key: keys){
                resValue+=key;
                resKey+=map.get(key);
            }
            map.put(resKey, resValue);
        }
    }
}
