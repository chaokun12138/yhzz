package com.hyzz.publish.service;

import com.hyzz.publish.mapper.CarMapper;
import com.hyzz.publish.pojo.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarMapper carMapper;

    public Car saveCar(Integer beginId,Integer endId,Integer vehicleTypeId,String tel){
        Car car = new Car();
        car.setBeginId(beginId);
        car.setEndId(endId);
        car.setVehicleTypeId(vehicleTypeId);
        car.setTel(tel);
        carMapper.insert(car);
        return car;
    }

    public List<Car> searchCar(Integer beginId,Integer endId){
        Car car = new Car();
        car.setBeginId(beginId);
        car.setEndId(endId);
        Example example = new Example(Car.class);
        example.createCriteria().equals(car);
        List<Car> cars = carMapper.selectByExample(example);
        return cars;
    }

    public int delectCarById(Integer Id){
        int i = carMapper.deleteByPrimaryKey(Id);
        return i;
    }
}
