package org.example;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        final Runnable task = () -> {
            try {
                lock.lock();
                for (int i = 0; i < (new Random().nextInt(100, 500)); i++) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                }
            } finally {
                lock.unlock();
            }
        };
        final Thread thread1 = new Thread(task);
        thread1.start();
        final Thread thread2 = new Thread(task);
        thread2.start();
    }
}