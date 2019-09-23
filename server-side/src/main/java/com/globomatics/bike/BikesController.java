package com.globomatics.bike;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikesController {

    private final BikeRepository bikeRepository;

    public BikesController(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    @GetMapping
    public ResponseEntity<List<Bike>> getBikes() {
        return ResponseEntity.ok(bikeRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bike> getBike(@PathVariable("id") Long id) {
        return ResponseEntity.of(bikeRepository.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createBike(@RequestBody  Bike bike) {
        bikeRepository.save(bike);
    }


}
