package com.arep.proyecto.parqueaderos.services;

import com.arep.proyecto.parqueaderos.entity.Car;
import com.arep.proyecto.parqueaderos.entity.Parking;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ParkingServices {

    List<Parking> getAllParking();

    Optional<Parking> getById(String id);

    List<Car> getCarsPerDay(String id, LocalDate fechaBusqueda);

    void updatePrice(String id, Parking parking);

    int updateParking(String idP);
}
