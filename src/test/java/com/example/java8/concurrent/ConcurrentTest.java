package com.example.java8.concurrent;

import org.junit.jupiter.api.Test;

public class ConcurrentTest {

    @Test
    public void concurrentTest() {

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread : " + Thread.currentThread().getName());
        });
        thread.start();

        System.out.println("World" + Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("Thread : " + Thread.currentThread().getName());
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
//                    System.out.println("exit!");
//                    return;
                }
            }

        });
        thread.start();

        System.out.println("World" + Thread.currentThread().getName());
//        thread.join();
        System.out.println(thread + "is finished");
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Thread:" + Thread.currentThread().getName());
        }
    }
}
