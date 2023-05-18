package com.arep.proyecto.parqueaderos.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Parkings")
public class Parking {

    @Id
    @Column(name = "idP")
    private String idP;
    @Column(name = "name")
    private String name;
    @Column(name = "ubication")
    private String ubication;
    @Column(name = "spaces")
    private int spaces;
    @Column(name = "priceP")
    private int priceP;
    @Column(name = "schedule")
    private String schedule;
    @Column(name = "total_spaces")
    private int totalSpaces;
    @OneToMany(mappedBy = "idC")
//    @JoinColumn(name = "idC")
    private List<Car> cars;

    public Parking(String idP, String name, String ubication, int spaces, int priceP, String schedule, int totalSpaces, List<Car> cars) {
        this.idP = idP;
        this.name = name;
        this.ubication = ubication;
        this.spaces = spaces;
        this.priceP = priceP;
        this.schedule = schedule;
        this.totalSpaces = totalSpaces;
        this.cars = cars;
    }

    public Parking() {
    }

    public String getId() {
        return idP;
    }

    public void setId(String idP) {
        this.idP = idP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getubication() {
        return ubication;
    }

    public void setubication(String ubication) {
        this.ubication = ubication;
    }

    public int getSpaces() {
        return spaces;
    }

    public void setSpaces(int spaces) {
        this.spaces = spaces;
    }

    public int getpriceP() {
        return priceP;
    }

    public void setpriceP(int priceP) {
        this.priceP = priceP;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public int getTotalSpaces() {
        return totalSpaces;
    }

    public void setTotalSpaces(int totalSpaces) {
        this.totalSpaces = totalSpaces;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
