package com.arep.proyecto.parqueaderos.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Entity
@Table(name = "Cars")
public class Car {

    @Id
    @GeneratedValue
    @Column(name = "idC")
    private String idC;
    @Column(name = "license")
    private String license;
    @Column(name = "arrive_time")
    private LocalDateTime arriveTime;
    @Column(name = "leave_time")
    private LocalDateTime leaveTime;
    @Column(name = "priceC")
    private int priceC;
    @JoinColumn(name = "idP", referencedColumnName = "idP")
    @ManyToOne(optional = true)
    private String parking;

    public Car(String idC, String license, LocalDateTime arriveTime, LocalDateTime leaveTime, int priceC, String parking) {
        this.idC = idC;
        this.license = license;
        this.arriveTime = arriveTime;
        this.leaveTime = leaveTime;
        this.priceC = priceC;
        this.parking = parking;
    }

    public Car(CarDto carDto){
        this.license = carDto.getLicense();
        this.arriveTime = carDto.getArriveTime();
        this.leaveTime = carDto.getLeaveTime();
        this.priceC = carDto.getPriceC();

    }

    public Car() {
    }

    public String getIdC() {
        return idC;
    }

    public void setIdC(String idC) {
        this.idC = idC;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public LocalDateTime getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(LocalDateTime arriveTime) {
        this.arriveTime = arriveTime;
    }

    public LocalDateTime getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(LocalDateTime leaveTime) {
        this.leaveTime = leaveTime;
    }

    public int getpriceC() {
        return priceC;
    }

    public void setpriceC(int priceC) {
        this.priceC = priceC;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }


}
