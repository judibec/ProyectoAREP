package com.arep.proyecto.parqueaderos.controller;

import com.arep.proyecto.parqueaderos.entity.Car;
import com.arep.proyecto.parqueaderos.entity.CarDto;
import com.arep.proyecto.parqueaderos.services.CarServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/car")
public class CarController {
    @Autowired
    CarServices carServices;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAll(){
        try {
            return new ResponseEntity<>(carServices.getAllCars(), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> newCarInParking(@RequestBody Car car){
        try{
            System.out.println(car.getLicense());
            return new ResponseEntity<>(carServices.newCarInParking(car), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
