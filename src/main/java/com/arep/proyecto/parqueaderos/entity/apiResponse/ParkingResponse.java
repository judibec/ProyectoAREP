package com.arep.proyecto.parqueaderos.entity.apiResponse;

import com.arep.proyecto.parqueaderos.entity.Parking;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ParkingResponse {
    @JsonProperty("name")
    private String name;

    @JsonProperty("spaces")
    private int spaces;

    @JsonProperty("ubication")
    private String ubication;

    public ParkingResponse() {
    }

    public ParkingResponse(String name, int spaces, String ubication) {
        this.name = name;
        this.spaces = spaces;
        this.ubication = ubication;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpaces() {
        return spaces;
    }

    public void setSpaces(int spaces) {
        this.spaces = spaces;
    }

    public String getUbication() {
        return ubication;
    }

    public void setUbication(String ubication) {
        this.ubication = ubication;
    }
}

