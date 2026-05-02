package com.misc.async.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public interface Tasks {

    void longRunningTask1();

    void longRunningTask2();

    CompletableFuture<String> processFuture();
    String processStringFuture() throws ExecutionException, InterruptedException;

}
