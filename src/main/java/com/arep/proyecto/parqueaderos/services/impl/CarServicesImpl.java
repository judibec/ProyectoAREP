package com.arep.proyecto.parqueaderos.services.impl;

import com.arep.proyecto.parqueaderos.entity.Car;
import com.arep.proyecto.parqueaderos.repository.CarRepository;
import com.arep.proyecto.parqueaderos.services.CarServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
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
        carRepository.save(car);
        System.out.println("paso");
        return carRepository.findById(String.valueOf(car.getIdC()));
    }

    @Override
    public void updateCar(Long id, int price) {
        if(carRepository.existsById(String.valueOf(id))){
            Optional<Car> car = carRepository.findById(String.valueOf(id));
            car.get().setLeaveTime(LocalDateTime.now());
            Duration duration = Duration.between(car.get().getLeaveTime(),car.get().getArriveTime());
            car.get().setpriceC((int) (duration.toMinutes()*(-price)));
            carRepository.save(car.get());
        }
    }
}
