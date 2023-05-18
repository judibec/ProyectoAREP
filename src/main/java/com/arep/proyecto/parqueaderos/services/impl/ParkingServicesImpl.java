package com.arep.proyecto.parqueaderos.services.impl;

import com.arep.proyecto.parqueaderos.entity.Car;
import com.arep.proyecto.parqueaderos.entity.Parking;
import com.arep.proyecto.parqueaderos.repository.ParkingRepository;
import com.arep.proyecto.parqueaderos.services.ParkingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @Override
    public List<Car> getCarsPerDay(String id, LocalDate fecha) {
        Optional<Parking> parkingOptional = parkingRepository.findById(id);
        if(parkingOptional.isPresent()){
            List<Car> carrosParqueadosEnDia = new ArrayList<>();
            for (Car car : parkingOptional.get().getCars()) {
                LocalDateTime arriveTime = car.getArriveTime();
                if (arriveTime.toLocalDate().equals(fecha)) {
                    carrosParqueadosEnDia.add(car);
                }
            }
            return carrosParqueadosEnDia;
        }else {
            return null;
        }
    }

    @Override
    public void updatePrice(String id, Parking parking) {
        if(parkingRepository.existsById(id)){
            Optional<Parking> parking1 = parkingRepository.findById(id);
            parking1.get().update(parking);
            parkingRepository.save(parking1.get());
        }
    }

    @Override
    public int updateParking(String idP) {
        if(parkingRepository.existsById(idP)){
            Optional<Parking> parking1 = parkingRepository.findById(idP);
            parking1.get().setSpaces(parking1.get().getSpaces()+1);
            parkingRepository.save(parking1.get());
            return parking1.get().getpriceP();
        }
        return 0;
    }
}
