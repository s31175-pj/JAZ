package pl.pjatk.lab3.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class SomeAdviceController {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleAllExceptions(Exception ex) {
        return ResponseEntity.badRequest().body("Exception occurred on request. Exception message: " + ex.getMessage());
    }
}
