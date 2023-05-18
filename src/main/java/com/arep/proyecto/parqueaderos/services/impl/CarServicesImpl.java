package com.arep.proyecto.parqueaderos.services.impl;

import com.arep.proyecto.parqueaderos.entity.Car;
import com.arep.proyecto.parqueaderos.entity.CarDto;
import com.arep.proyecto.parqueaderos.repository.CarRepository;
import com.arep.proyecto.parqueaderos.services.CarServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServicesImpl implements CarServices {

    @Autowired
    CarRepository carRepository;

    @Override
    public List<Car> getAllCars() {
        return (List<Car>) carRepository.findAll();
    }

    @Override
    public Optional<Car> newCarInParking(Car car){
        System.out.println("Llego aqui");
        carRepository.save(car);
        System.out.println("paso");
        return carRepository.findById(Integer.valueOf(car.getIdC()));
    }
}
