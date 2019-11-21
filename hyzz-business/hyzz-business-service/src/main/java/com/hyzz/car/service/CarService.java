package com.hyzz.car.service;

import com.hyzz.car.mapper.CarMapper;
import com.hyzz.pojo.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarMapper carMapper;

    public Car queryCarById(Integer id) {
        return carMapper.selectByPrimaryKey(id);

    }
}
