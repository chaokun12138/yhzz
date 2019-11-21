package com.hyzz.car.controller;

import com.hyzz.car.service.CarService;
import com.hyzz.pojo.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    /**
     * 根据Id查询车源
     * @param id
     * @return
     */
    @GetMapping("/car/{id}")
    public ResponseEntity<Car> queryCarById(
            @PathVariable("id") Integer id){
        return ResponseEntity.ok(carService.queryCarById(id));
    }



}
