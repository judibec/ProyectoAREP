package com.arep.proyecto.parqueaderos.repository;

import com.arep.proyecto.parqueaderos.entity.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car,String> {
}
