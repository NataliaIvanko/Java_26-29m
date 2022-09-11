package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args) {

        // Дан список Programmer(String name, String city, List<Task>  tasks). Каждый программист  имеет список задач
        // Task (int Number, String description, String status, int daysInProcessing) . Сформировать лист из всех задач,
        // которые относятся к программистам из Берлина, не завершены (т.е. имеют статус, отличный от «done») и висят
        // в обработке более 5 дней.
        List<Task> tasks = new ArrayList<>();

        Task task1 = new Task(1, "write code for a new programme", "in process", 8);
        Task task2 = new Task(2, "update code for the existing programme", "done", 6);
        Task task3 = new Task(3, "test code", "done", 1);
        Task task4 = new Task(4, "fix coding errors", "in process", 10);
        Task task5 = new Task(5, "secure programmes", "in process", 15);
        Task task6 = new Task(6, "design", "done", 6);
        Task task7 = new Task(7, "fix bugs", "in process", 3);


        List<Programmer> programmers = List.of(new Programmer("Jack", "Berlin", List.of(task1)),
                new Programmer("Jane", "Hamburg", List.of(task2)),
                new Programmer("Kate", "Berlin", List.of(task3)),
                new Programmer("Nick", "Berlin", List.of(task4)),
                new Programmer("Mary", "Berlin", List.of(task5)),
                new Programmer("Liza", "Berlin", List.of(task6)),
                new Programmer("Josh", "Berlin", List.of(task7))

        );
        List<String> list = List.of("Иванов Иван Иванович: 645", "Петров Петр Петрович: 458", "Ерофеев Ерофей Ерофеевич: 867", "Миронов Мирон Миронович: 783");


         System.out.println(tasksStillInProcessLongerThan6Days(programmers));
         System.out.println(taskTheLongestInProcess(programmers));
         System.out.println(taskAndDaysInProcess(programmers));
         System.out.println(sortedListMoreThan500(list, 500));
         System.out.println(first20FibonacciNumbers(20));


    }

    public static List<Task> tasksStillInProcessLongerThan6Days(List<Programmer> pr) {
        return pr.stream()
                .filter(p -> p.getCity().equals("Berlin"))
                .flatMap(p -> p.getTasks().stream())
                .filter(t -> !t.getStatus().equals("done") && t.getDaysInProcess() > 5)
                .collect(Collectors.toList());
    }
    //  Дан список Programmer(String name, String city, List<Task>  tasks). Каждый программист  имеет список задач
    //  Task (int Number, String description, String status, int daysInProcessing) .
    //  Сформировать лист из дести задач которые дольше всего находятся в работе.


    public static List<Task> taskTheLongestInProcess(List<Programmer> pr) {

        return pr.stream()
                .flatMap(p -> p.getTasks().stream())
                .sorted(Comparator.comparing(Task::getDaysInProcess, Comparator.reverseOrder()))
                .limit(6)
                .collect(Collectors.toList());
    }
    //Дан список Programmer(String name, String city, List<Task>  tasks). Каждый программист  имеет список задач
    // Task (int Number, String description, String status, int daysInProcessing) .
    // Сформировать лист строк вида «Программист:НомерЗадача:ДнейВOбработке».

    public static List<String> taskAndDaysInProcess(List<Programmer> pr) {
        return pr.stream()
                .flatMap(p -> p.getTasks()
                        .stream()
                        .map(t -> p.getName() + ": task number " + t.getNumber() + ", days in process=" + t.getDaysInProcess())/*sorted(String::compareTo)*/)
                .collect(Collectors.toList());
    }
    //Дан список строк «Иванов Иван Иванович: 645» Сформировать отсортированный по числовому полю список строк вида: «645:Иванов И.И.»,
    // при этом отобрать только те строки, где числовое поле больше 500.

    public static List<String> sortedListMoreThan500(List<String> list, int value) {
        return list.stream()
                .filter(s -> extractNumber(s) > value)
                .sorted(Comparator.comparing(s -> extractNumber(s)))
                .map(s -> s.split(" ")[3] + ": " + s.split(" ")[0] + " " + s.split(" ")[1].substring(0, 1) + "." + s.split(" ")[2].substring(0, 1) + ".")
                .collect(Collectors.toList());

    }
    public static int extractNumber(String str) {
        return Integer.parseInt(str.replaceAll("[\\D]", ""));

    }
    //Используя стримы, сформировать список из первых N чисел Fibonacci

    public static List<Integer> first20FibonacciNumbers(int quantity) {
        return Stream.iterate(new int[]{0, 1}, i -> new int[]{i[1], i[0] + i[1]})
                .limit(20)
                .map(i -> i[0])      //keeps the first element of each array
                .collect(Collectors.toList());
    }


}
