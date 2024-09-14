package carapibasics;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Postman -> URL: http://localhost:8080/cars
@RestController
@RequestMapping("/cars")
public class CarController {
    List<Car> carList = new ArrayList<>(); // REST API teszteléshez lista létrehozása

    // Postman (GET) -> URL: http://localhost:8080/cars | Autó lista lekérdezése
    @GetMapping
    public Object getAllCars() {
        return carList.isEmpty() ? "Nem található autó a listában." : carList;
    }

    // Postman (POST) -> URL: http://localhost:8080/cars | Autó létrehozása
    // @RequestBody: a JSON blokk, pl.: {"brand":"Audi","model":"A8","year": 2018}
    @PostMapping
    public ResponseEntity<List<Car>> createCar(@RequestBody Car car) {
        car.setId(System.currentTimeMillis());
        carList.add(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(carList);
    }

    // Postman (GET) -> URL: http://localhost:8080/cars/{id}, {id}: a létrehozott autó egyedi azonosítója (ID)
    @GetMapping("/{id}")
    public ResponseEntity<?> getCarById(@PathVariable("id") Long id) {
        /* Hagyományos módszer */
        Car foundCar = null;
        for (Car car : carList) {
            if (car.getId().equals(id)) {
                foundCar = car;
                break;
            }
        }

        // Ellenőrzés, hogy a foundCar objektum nem null-e (v1)
        /*if (foundCar != null) {
            return ResponseEntity.ok(foundCar);
        } else {
            return ResponseEntity.notFound().build();
        }*/

        // Ellenőrzés, hogy a foundCar objektum nem null-e (v2)
        //return (foundCar != null) ? ResponseEntity.ok(foundCar) : ResponseEntity.notFound().build();

        /* Modern változat */
        Optional<Car> optionalCar = carList.stream().filter(car -> car.getId().equals(id)).findFirst();
        //return optionalCar.map(body -> ResponseEntity.ok(body)).orElse(ResponseEntity.notFound().build()); // Response küldése alapértelmezett hibaüzenettel (ha hiba lép fel)
        return optionalCar.<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>("Nem található ID: " + id + " autó.", HttpStatus.NOT_FOUND)); // Response küldése egyedi hibaüzenettel (ha hiba lép fel)

        // PUT, DELETE metódusok létrehozása folyamatban...
    }
}
