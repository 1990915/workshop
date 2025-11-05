package com.misc.controller;

import com.misc.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/purchase")
    public void hiController() {
        System.out.println("Started ...");
        personService.savePerson();
        System.out.println("Finished");
    }
}
