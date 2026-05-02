package com.misc.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class AsyncService implements Tasks{

    @Async
    @Override
    public void longRunningTask1() {
        System.out.println("longRunningTask1 started: " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000); // شبیه‌سازی کار سنگین
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("longRunningTask1 finished: " + Thread.currentThread().getName());
    }

    @Async
    @Override
    public void longRunningTask2() {
        System.out.println("longRunningTask2 started: " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000); // شبیه‌سازی کار سنگین
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("longRunningTask2 finished: " + Thread.currentThread().getName());
    }

    @Override
    @Async
    public CompletableFuture<String> processFuture() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture("Done!");
    }

    @Override
    @Async
    public String processStringFuture() throws ExecutionException, InterruptedException {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture("Done!").get();
    }

}