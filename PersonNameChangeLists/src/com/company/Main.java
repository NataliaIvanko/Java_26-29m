package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Дан лист из строк. Нам нужно все строки, которые дляннее, чем 4 символа, заменить на 1 четыре символа из этой строки
        User u1 = new User("Sand", "Jessica", 15);
        User u2 = new User("Clarks", "Jennifer", 38);
        User u3 = new User("Dowson", "Robert", 41);

        List<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        System.out.println(list);
        swapFirstNameLastName(list);
        System.out.println(list);

        List<String> strList = Arrays.asList("wqzreu", "hlfsfj", "ghjz");
        trimToFourCharacters(strList);
        System.out.println(strList);

    }

    public static void swapFirstNameLastName(List<User> list) {

        for (User user : list) {
            String temp = user.getfName();
            user.setfName(user.getlName());
            user.setlName(temp);


        }
    }

    public static void trimToFourCharacters(List<String> strList) {

        for (int i = 0; i < strList.size(); i++) {
            String s = strList.get(i);
            s = s.length() > 4 ? s.substring(0, 4) : s;
            strList.set(i, s);
        }
    }

    public static void trimToFourCharacters1(List<String> strList) {
        for (int i = 0; i < strList.size(); i++) {

            String s = strList.get(i);
            if(s.length()>4)
            strList.set(i, s.substring(0, 4));
        }
    }
    public static void trimToFourCharacters2(List<String> strList) {
        int i = 0;
        for(String s : strList){
            if(s.length()>4){
                strList.set(i, s.substring(0,4));
            }
            i++;
        }

    }
}


