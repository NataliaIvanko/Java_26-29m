package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String, String> mapStr = new HashMap<>();
        mapStr.put("a", "Hi");
        mapStr.put("b", "There");
        mapStr.put("c", "What");
        mapStr.put("d", "are");
        mapStr.put("e", "you");
        mapStr.put("f", "doing");
        System.out.println(concatAB(mapStr));

    }
    public static Map<String, String>concatAB(Map<String, String>mapStr){
        if(mapStr.containsKey("a") && mapStr.containsKey("b")){
            Map<String, String>mapAB = new HashMap<>();
            mapAB.put("ab", mapStr.get("a").concat(mapStr.get("b")));
            return mapAB;
        }
        return mapStr;
    }
}
