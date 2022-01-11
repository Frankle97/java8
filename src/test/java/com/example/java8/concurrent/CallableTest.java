package com.example.java8.concurrent;

import java.util.concurrent.*;

public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> hello = () -> {
          Thread.sleep(2000L);
            return "Hello";
        };

        Future<String> helloFuture = executorService.submit(hello);
        System.out.println(helloFuture.isDone());
        System.out.println("START");

//        helloFuture.get();
        helloFuture.cancel(false);

        System.out.println(helloFuture.isDone());
        System.out.println("END");
        executorService.shutdown();
    }
}
