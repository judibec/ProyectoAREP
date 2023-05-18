package com.arep.proyecto.parqueaderos.services;

import com.arep.proyecto.parqueaderos.entity.Parking;

import java.util.List;
import java.util.Optional;

public interface ParkingServices {

    List<Parking> getAllParking();

    Optional<Parking> getById(String id);
}
