package com.arep.proyecto.parqueaderos.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

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
    private Integer priceC;

//    private String idP;
    @ManyToOne
    @JoinColumn(name = "idP")
//    @JsonIgnore
    @JsonBackReference
    @JsonIdentityReference(alwaysAsId = true)
    private Parking parking;



    public Car(String idC, String license, LocalDateTime arriveTime, LocalDateTime leaveTime, int priceC, Parking parking) {
        this.idC = idC;
        this.license = license;
        this.arriveTime = arriveTime;
        this.leaveTime = leaveTime;
        this.priceC = priceC;
        this.parking = parking;
    }

    public Car(String license, LocalDateTime arriveTime, LocalDateTime leaveTime, int priceC, String idP) {
        System.out.println("LLego al que era :)");
        this.license = license;
        this.arriveTime = arriveTime;
        this.leaveTime = leaveTime;
        this.priceC = priceC;
//        this.idP = idP;
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

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }


}
