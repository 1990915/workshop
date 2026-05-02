package com.misc.async.service;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequiredArgsConstructor
public class AsyncController {

    private final Tasks asyncService;

    @GetMapping("/async")
    public String callAsync() {
        asyncService.longRunningTask1();
        asyncService.longRunningTask2();
        return "Request accepted!";
    }

    @GetMapping("/future")
    public String future() throws ExecutionException, InterruptedException {
        return asyncService.processFuture()
                .thenApply(result -> {
                    System.out.println("Callback thread:" + Thread.currentThread().getName());
                    return result + " World!";
                }).get();
    }

    @GetMapping("/asyncStringFuture")
    public String asyncStringFuture() throws ExecutionException, InterruptedException {
        String result = asyncService.processStringFuture();
        return "asyncStringFuture:" + result;
    }
}