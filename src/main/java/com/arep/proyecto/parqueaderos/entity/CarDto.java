package com.arep.proyecto.parqueaderos.entity;

import java.time.LocalDateTime;

public class CarDto {
    private String license;
    private LocalDateTime arriveTime;
    private LocalDateTime leaveTime;
    private int priceC;
    private int idP;

    public CarDto() {
    }

    public String getLicense() {
        return license;
    }

    public LocalDateTime getArriveTime() {
        return arriveTime;
    }

    public LocalDateTime getLeaveTime() {
        return leaveTime;
    }

    public int getPriceC() {
        return priceC;
    }

    public int getIdP() {
        return idP;
    }
}
