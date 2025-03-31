package pl.pjatk.lab3;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("homework")
public class HomeworkController {


    @GetMapping("{someValue}")
    public ResponseEntity<String> path(@PathVariable String someValue)
    {
        return ResponseEntity.ok(someValue);
    }

    @GetMapping("{someValue}")
    public ResponseEntity<String> request(@RequestParam String someValue)
    {
        return ResponseEntity.ok(someValue);
    }

    @PutMapping("put/{someValue}")
    public ResponseEntity<Car> newPut(@PathVariable String model, @RequestParam Car updatedCar)
    {
        updatedCar.setModel(model);
        return ResponseEntity.ok(updatedCar);
    }

    @PostMapping("post")
    public ResponseEntity<Car> newPost(@RequestBody Car updatedCar)
    {
        return ResponseEntity.ok(updatedCar);
    }

    @PostMapping("delete/{someValue}")
    public ResponseEntity<Car> newDelete(@PathVariable String model)
    {
        
        return ResponseEntity.ok(car);
    }
}
