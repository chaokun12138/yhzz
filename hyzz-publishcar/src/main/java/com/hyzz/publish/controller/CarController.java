package com.hyzz.publish.controller;


import com.hyzz.publish.pojo.Car;
import com.hyzz.publish.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/add")
    @ResponseBody
    public Car addCar(@RequestParam Integer beginId,@RequestParam Integer endId,@RequestParam Integer vehicleTypeId,@RequestParam String tel){
        Car car = carService.saveCar(beginId, endId, vehicleTypeId, tel);
        return car;
    }

    @GetMapping("/search")
    @ResponseBody
    public List searchCar(@RequestParam Integer beginId, @RequestParam Integer endId){
        List cars = carService.searchCar(beginId, endId);
        System.out.println(cars);
        return cars;
    }

    @DeleteMapping("/delectcar")
    @ResponseBody
    public int delectcar(Integer Id){
        int i = carService.delectCarById(Id);
        return i;
    }
}
