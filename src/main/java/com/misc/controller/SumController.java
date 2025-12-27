package com.misc.controller;

import com.misc.service.SumService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SumController {

    private final SumService sumService;

    public SumController(SumService sumService) {
        this.sumService = sumService;
    }

    @GetMapping("/sum")
    public void hiController() {
        System.out.println("Started ...");
        int sum = sumService.sum(null, 20);
        System.out.println("sum=" + sum);
        System.out.println("Finished");
    }
}
