package br.com.weslley.controllers;

import br.com.weslley.model.GoodBye;
import br.com.weslley.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private static final String message = "Good bye, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "Word") String name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping("/goodbye")
    public GoodBye goodBye(@RequestParam(value = "name", defaultValue = "User") String name){
        return new GoodBye(counter.incrementAndGet(), String.format(message, name));
    }
}
