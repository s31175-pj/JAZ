package pl.pjatk.lab3.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.lab3.pojos.Car;

@RestController
@RequestMapping("test")
public class WebController {

//    @GetMapping("hello")
//    public ResponseEntity<String> hello()
//    {
//
//        return ResponseEntity.ok("Hello World");
//
//    }

//    @GetMapping("hello/{someValue}")
//    public ResponseEntity<String> diffValue(@PathVariable String someValue)
//    {
//
//        return ResponseEntity.ok(someValue);
//
//    }

    @GetMapping("/hello")
    public ResponseEntity<String> helloWithParam(@RequestParam(value = "reqParam") String reqParamValue) {
        // Możesz tutaj wykonać jakąś logikę na podstawie wartości reqParamValue

        // Tworzymy ResponseEntity z przekazaną wartością i statusem HTTP 200 OK
        return new ResponseEntity<>(reqParamValue, HttpStatus.OK);
    }

//    @GetMapping("model")
//    public ResponseEntity<Car> model()
//    {
//        Car car = new Car();
////        car.setBrand("Toyota");
////        car.setModel("Corolla");
////        car.setYear(2020);
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
