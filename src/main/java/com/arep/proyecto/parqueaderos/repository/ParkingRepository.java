package com.arep.proyecto.parqueaderos.repository;

import com.arep.proyecto.parqueaderos.entity.Parking;
import org.springframework.data.repository.CrudRepository;

public interface ParkingRepository extends CrudRepository<Parking,String> {
}
