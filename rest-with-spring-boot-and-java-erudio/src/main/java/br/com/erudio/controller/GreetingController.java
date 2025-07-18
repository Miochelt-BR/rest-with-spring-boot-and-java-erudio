package br.com.erudio.controller;

import br.com.erudio.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template ="hello, %s!";
    private  final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(
            @RequestParam(value = "name",defaultValue = "word")
            String name ){
        return  new Greeting(counter.incrementAndGet(),String.format(template,name));
    }
}
