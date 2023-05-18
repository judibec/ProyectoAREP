package com.arep.proyecto.parqueaderos.services;

import com.arep.proyecto.parqueaderos.entity.Car;

import java.util.List;
import java.util.Optional;

public interface CarServices {
    List<Car> getAllCars();

    Optional<Car> newCarInParking(Car car);

    void updateCar(String id, int price);
}
