package com.company.Task1;

import javax.swing.*;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	// Реализовать многопоточное заполнение массива на N элементов (например, на 1000000 элементов) случайными числами.
        // При том каждый поток заполняет свой участок массива (например, если два потока то один заполняет с 0 по 499999 элементы,
        // а второй оставшиеся). Заполнить массив в 1 поток, в 3 потока, в 5 потоков. Засечь время заполнения.
        // Сравнить результаты и выяснить самый эффективный способ.

        int[] array = new int[100_000_000];
        Random random = new Random(System.currentTimeMillis());

        Instant start = Instant.now();

        for (int i = 0; i < 100_000_000; i++) {
            array[i] = random.nextInt();
        }


        Instant finish = Instant.now();

        System.out.println("one thread: " + ChronoUnit.MILLIS.between(start, finish));

        Runnable runnable1 = () -> {
            for (int i = 0; i <50_000_000; i++) {
                array[i] = random.nextInt();
            }
        };
        Runnable runnable2 = () -> {
            for (int i = 50_000_000; i < 100_000_000;i++) {
                array[i] = random.nextInt();
            }
        };
        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);

        start = Instant.now();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        finish = Instant.now();

        System.out.println("two threads: " + ChronoUnit.MILLIS.between(start, finish));

        Runnable runnable_1 = () -> {
            for (int i = 0; i <20_000_000; i++) {
                array[i] = random.nextInt();
            }
        };
        Runnable runnable_2 = () -> {
            for (int i = 20_000_000; i < 40_000_000;i++) {
                array[i] = random.nextInt();
            }
        };
        Runnable runnable_3 = () -> {
            for (int i = 40_000_000; i < 60_000_000;i++) {
                array[i] = random.nextInt();
            }
        };
        Runnable runnable_4 = () -> {
            for (int i = 60_000_000; i < 80_000_000;i++) {
                array[i] = random.nextInt();
            }
        };
        Runnable runnable_5 = () -> {
            for (int i = 80_000_000; i < 100_000_000;i++) {
                array[i] = random.nextInt();
            }
        };
        Thread t_1 = new Thread(runnable_1);
        Thread t_2 = new Thread(runnable_2);
        Thread t_3 = new Thread(runnable_3);
        Thread t_4 = new Thread(runnable_4);
        Thread t_5 = new Thread(runnable_5);

        start = Instant.now();
        t_1.start();
        t_2.start();
        t_3.start();
        t_4.start();
        t_5.start();
        t_1.join();
        t_2.join();
        t_3.join();
        t_4.join();
        t_5.join();
        finish = Instant.now();

        System.out.println("five threads: " + ChronoUnit.MILLIS.between(start, finish));
    }
}
