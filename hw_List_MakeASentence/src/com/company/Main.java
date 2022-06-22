package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> sentence = Arrays.asList("I", "always", "do", "my", "homework");

        System.out.println(combineTheWords(sentence));
        System.out.println(combineTheWords2(sentence));
        System.out.println(concatWordsLessThanFourSymbolsFirst(sentence));
    }

    public static String combineTheWords(List<String> sentence) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentence.size(); i++) {
            String s = sentence.get(i);
            sb.append(s + " ");

        }
        return sb.toString();
    }

    public static String combineTheWords2(List<String> sentence) {
        String str = "";
        return str = String.join(" ", sentence);
    }

    public static String concatWordsLessThanFourSymbolsFirst(List<String> sentence) {

        String str1 = "";
        String str2 = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentence.size(); i++) {
            String s = sentence.get(i);
            if (s.length() < 4) {
                str1+=s + " ";

            }else{
                str2+=s + " ";
            }
        }
        return str1 + " " +  str2;

        }

    public static String concatWordsLessThanFourSymbolsFirst1(List<String> sentence){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentence.size(); i++) {
            String s = sentence.get(i);
            if (s.length() < 4) {
                Collections.swap(sentence, i, 0);
            }
        }
            for (int i = 0; i < sentence.size(); i++) {
                String s = sentence.get(i);

                sb.append(s + " ");

            }
            return sb.toString();
    }

}
