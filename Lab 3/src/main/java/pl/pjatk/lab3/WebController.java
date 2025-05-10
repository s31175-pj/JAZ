package pl.pjatk.lab3;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("test")
public class WebController {

    @GetMapping("hello")
    public ResponseEntity<String> hello()
    {

        return ResponseEntity.ok("Hello World");

    }

//    @GetMapping("hello/{someValue}")
//    public ResponseEntity<String> diffValue(@PathVariable String someValue)
//    {
//
//        return ResponseEntity.ok(someValue);
//
//    }

    @GetMapping("hello/{someValue}")
    public ResponseEntity<String> diffValue(@RequestParam("someValue") String someValue)
    {

        return ResponseEntity.ok(someValue);

    }

//    @GetMapping("model")
//    public ResponseEntity<Car> model()
//    {
//        Car car = new Car();
//        car.setBrand("Toyota");
//        car.setModel("Corolla");
//        car.setYear(2020);
//        return ResponseEntity.ok(car);
//    }

    @PostMapping("model")
    public ResponseEntity<Car> createCar(@RequestBody Car car)
    {
//        Car car = new Car();
//        car.setBrand("Toyota");
//        car.setModel("Corolla");
//        car.setYear(2020);
        return ResponseEntity.ok(car);
    }
}
