package com.arep.proyecto.parqueaderos.services.impl;

import com.arep.proyecto.parqueaderos.entity.Parking;
import com.arep.proyecto.parqueaderos.repository.ParkingRepository;
import com.arep.proyecto.parqueaderos.services.ParkingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingServicesImpl implements ParkingServices {

    @Autowired
    ParkingRepository parkingRepository;


    @Override
    public List<Parking> getAllParking() {
        return (List<Parking>) parkingRepository.findAll();
    }
}
