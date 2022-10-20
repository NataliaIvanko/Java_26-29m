package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) throws IOException {

        while(true){
            String firstName = readFile();

            String age = consoleInput("How old are you: ");

            String person = String.format("%s-%s", firstName, age);
            write(person);

            String end = consoleInput("Shall we stop here?");
            if(end.equalsIgnoreCase("yes")) {
                break;
            }
        }
        /*
        String firstName = readFile("Name:");
        String question = getConsoleMessage("How old are you?");
        System.out.println(firstName +" " + question);

         */
    }

    private static String consoleInput(String str){
        System.out.println(str);
        return new Scanner(System.in).nextLine();
    }
    public static String readFile() throws IOException {
      //  System.out.println(text);
        BufferedReader bufferedReader = new BufferedReader(new FileReader("1.txt"));

        String line;
        StringBuilder sb = new StringBuilder();

        while(true){
            try {
                line = bufferedReader.readLine();
                if (line == null || line.isEmpty()) {
                    break;
                }
                System.out.println(line);
                sb.append(line);
                sb.append('\n');
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();

    }

    private static void write(String message) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("1.txt"));
        bufferedWriter.write(message);
        bufferedWriter.write("\n");
        bufferedWriter.flush();
        bufferedWriter.close();
    }

}
