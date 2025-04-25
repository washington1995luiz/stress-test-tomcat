package br.com.washington.stress_test_tomcat.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String greeting(){
        return "Welcome to my application!\nNew Version...\n\n\nGood Bye!";
    }
}
