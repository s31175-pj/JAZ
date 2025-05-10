package pl.pjatk.lab3;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("homework")
public class HomeworkController {


    @GetMapping("path/{pathValue}")
    public ResponseEntity<String> path(@PathVariable String pathValue)
    {
        return ResponseEntity.ok(pathValue);
    }

    @GetMapping("request")
    public ResponseEntity<String> request(@RequestParam String requestValue)
    {
        return ResponseEntity.ok(requestValue);
    }

    @PutMapping("put/{model}")
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

    @DeleteMapping("delete/{model}")
    public ResponseEntity<Void> newDelete(@PathVariable String model)
    {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
