package pl.pjatk.lab3.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.lab3.pojos.Car;

@RestController
@RequestMapping("homework")
public class HomeworkController {


    @GetMapping("get/{someValue}")
    public ResponseEntity<String> path(@PathVariable String someValue)
    {
        return ResponseEntity.ok(someValue);
    }

    @GetMapping("get")
    public ResponseEntity<String> request(@RequestParam String someValue)
    {
        return ResponseEntity.ok(someValue);
    }

    @PutMapping("put/{someValue}")
    public ResponseEntity<Car> newPut(@PathVariable String someValue, @RequestBody Car updatedCar)
    {
        updatedCar.setModel(someValue);
        return ResponseEntity.ok(updatedCar);
    }

    @PostMapping("post")
    public ResponseEntity<Car> newPost(@RequestBody Car updatedCar)
    {
        return ResponseEntity.ok(updatedCar);
    }

    @DeleteMapping("delete/{someValue}")
    public ResponseEntity<Void> newDelete(@PathVariable String model)
    {

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
