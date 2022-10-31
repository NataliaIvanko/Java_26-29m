package com.company.Task2;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        //Реализовать 2 потока. Один должен печатать слово ping 20 раз, второй должен печатать слово pong.
        // Запустить и синхронизировать потоки таким способом, чтобы программа выводила ping pong ping pong ……

      final Object lock = new Object();
      Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    synchronized (lock) {
                        System.out.println("Ping");

                        try {
                            lock.wait(); //suspends a thread
                            lock.notify(); //wakes up a thread
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    synchronized (lock) {
                        lock.notify();

                        System.out.println("Pong");
                        try {

                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();


    }

}





