package com.misc;

import org.jpos.q2.Q2;
import org.jpos.util.LogEvent;
import org.jpos.util.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;

@SpringBootApplication(scanBasePackages = "com.misc")
public class Starter {

    public static void main(String[] args) throws FileNotFoundException {
        SpringApplication.run(Starter.class, args);
        Q2 q2 = new Q2(ResourceUtils.getFile("classpath:deploy").getAbsolutePath());
        q2.start();
        Logger.log(new LogEvent("CardIran Channel is Started Successfully."));
        System.out.println("CardIran Channel  is Started Successfully ...");
    }
}
