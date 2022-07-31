package com.company;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //8.  	Используя Scanner написать программу, которая позволяет пользователю ввести с клавиатуры список Person {String name, MyDate birthday}
        // MyDate – класс {int day, int month, int year}.
        // Программа должна корректно обрабатывать вводимые пользователем данные, проверять корректность данных
        // и если данные некорректны, запрашивать повторный ввод. Если пользователь ввел “finsh”,
        // программа должна распечатать получившийся список пользователей, отсортировав пользователей по возрасту, и завершить свое выполнение.

        List<Person> list = createList();
        System.out.println(list);

    }

    public static List<Person> createList() {
        List<Person> listPerson = new ArrayList<>();


        Scanner sc = new Scanner(System.in);
        String continueKey = "nsadf";
        String personName = "";
        String strMyDate = "";

        int i = 0;

        Boolean nameKey = false;
        Boolean dateKey = false;
        while (!continueKey.toLowerCase().trim().equals("y")) {
            nameKey = false;
            dateKey = false;
            System.out.println("Please enter your name");
            while (!nameKey) {
                personName = sc.next();
                nameKey = checkName(personName);
            }
            System.out.println("Please enter your birthday in the format day-month-year using - as a separator ");
            while (!dateKey) {
                strMyDate = sc.next();
                dateKey = checkDate(strMyDate);
             }

            System.out.println("Finish? Yes/No");
            continueKey = sc.next();
            System.out.println(continueKey);
            MyDate myDate = new MyDate(strMyDate);
            listPerson.add(new Person(personName, myDate));
        }
        sc.close();
        return listPerson;
    }

    public static boolean checkName(String personName) {
        if (personName == null || personName.trim().isEmpty())
            throw new IllegalArgumentException("Field name is empty");

        if(!personName.matches("^[a-zA-Z]*$")) {
            System.out.println(("Only letters of Latin alphabet are allowed"));
            return false;
        }
        return true;
    }

    public static boolean checkDate(String str) {
        int year = 0;
        int month = 0;
        int day = 0;
        String[] values = str.split("-");
        if(values.length!=3){
            System.out.println("Invalid date format");
            return false;
        }
        try{
        day = Integer.parseInt(values[0]);
        month = Integer.parseInt(values[1]);
        year = Integer.parseInt(values[2]);
        }catch(NumberFormatException e){
            System.out.println("Please enter numbers only");
        }
        int currentYear = Year.now().getValue();
        if (month > 12 || month < 1 || day > 31 || day < 1 || year < currentYear - 120 || year > currentYear) {
            System.out.println("Invalid date format. Please enter your birthday");
            return false;

            //     throw new NumberFormatException("Wrong date format");
        }

        return true;
    }
}
