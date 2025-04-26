package pl.pjatk.lab3.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {

    @GetMapping("exception")
    public void triggerException() {
        throw new RuntimeException();
    }



}
