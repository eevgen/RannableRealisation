package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        final Runnable task = () -> {
            for (int i = 0; i < (new Random().nextInt(100, 500)); i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        };
        final Thread thread1 = new Thread(task);
        thread1.start();
        final Thread thread2 = new Thread(task);
        thread2.start();
    }
}