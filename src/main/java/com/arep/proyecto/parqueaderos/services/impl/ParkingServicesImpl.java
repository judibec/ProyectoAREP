package com.arep.proyecto.parqueaderos.services.impl;

import com.arep.proyecto.parqueaderos.entity.Parking;
import com.arep.proyecto.parqueaderos.repository.ParkingRepository;
import com.arep.proyecto.parqueaderos.services.ParkingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParkingServicesImpl implements ParkingServices {

    @Autowired
    ParkingRepository parkingRepository;


    @Override
    public List<Parking> getAllParking() {
        return (List<Parking>) parkingRepository.findAll();
    }

    @Override
    public Optional<Parking> getById(String id) {
        Optional<Parking> parkingOptional = parkingRepository.findById(id);
        if (parkingOptional.isPresent()) {
            Parking parking = parkingOptional.get();
            Parking simplifiedParking = new Parking();
            simplifiedParking.setSpaces(parking.getSpaces());
            simplifiedParking.setName(parking.getName());
            simplifiedParking.setubication(parking.getubication());
            return Optional.of(simplifiedParking);
        } else {
            return Optional.empty();
        }
    }
}
