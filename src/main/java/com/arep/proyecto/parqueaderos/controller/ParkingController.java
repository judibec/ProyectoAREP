package com.arep.proyecto.parqueaderos.controller;

import com.arep.proyecto.parqueaderos.entity.Parking;
import com.arep.proyecto.parqueaderos.entity.apiResponse.ParkingResponse;
import com.arep.proyecto.parqueaderos.repository.ParkingRepository;
import com.arep.proyecto.parqueaderos.services.ParkingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/parking")
public class ParkingController {
    @Autowired
    ParkingServices parkingServices;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAll(){
        try {
            return new ResponseEntity<>(parkingServices.getAllParking(), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> getById(@PathVariable String id) {
        try {
            Parking parking = parkingServices.getById(id).get();
            String name = parking.getName();
            int places = parking.getSpaces();
            String ubication = parking.getubication();
            return new ResponseEntity<>(new ParkingResponse(name, places, ubication), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
