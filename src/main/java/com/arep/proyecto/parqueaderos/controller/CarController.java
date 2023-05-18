package com.arep.proyecto.parqueaderos.controller;

import com.arep.proyecto.parqueaderos.entity.Car;
import com.arep.proyecto.parqueaderos.entity.CarDto;
import com.arep.proyecto.parqueaderos.services.CarServices;
import com.arep.proyecto.parqueaderos.services.ParkingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/car")
public class CarController {
    @Autowired
    CarServices carServices;

    @Autowired
    ParkingServices parkingServices;

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

    @RequestMapping(method = RequestMethod.PUT, path = "/{idC}/{idP}")
    public ResponseEntity<?> updateCarAndPlaces(@PathVariable String idC, @PathVariable String idP){
        try{
            int price = parkingServices.updateParking(idP);
            carServices.updateCar(idC, price);
            return new ResponseEntity<> (HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
