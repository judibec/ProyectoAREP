package com.arep.proyecto.parqueaderos.controller;

import com.arep.proyecto.parqueaderos.entity.Parking;
import com.arep.proyecto.parqueaderos.entity.apiResponse.ParkingResponse;
import com.arep.proyecto.parqueaderos.repository.ParkingRepository;
import com.arep.proyecto.parqueaderos.services.ParkingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

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

    @RequestMapping(method = RequestMethod.GET, path = "/{id}/diario")
    public ResponseEntity<?> getCarsPerDay(@PathVariable String id, @Param("fecha") String fecha){
        try {
            LocalDate fechaBusqueda = LocalDate.parse(fecha);
            return new ResponseEntity<>(parkingServices.getCarsPerDay(id,fechaBusqueda), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateTask(@PathVariable String id,@RequestBody Parking parking){
        try {
            parkingServices.updatePrice(id, parking);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
