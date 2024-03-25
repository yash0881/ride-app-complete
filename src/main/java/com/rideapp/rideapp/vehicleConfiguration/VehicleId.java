package com.rideapp.rideapp.vehicleConfiguration;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Embeddable
public class VehicleId implements Serializable {
    @Column(length = 50, unique = true)
    private String vehicleNumber;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private VehicleType vehicleType;

    @Column(length = 50)
    private String city;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private AreaType areaType;


    public VehicleId() {
    }

    public VehicleId(String vehicleNumber, VehicleType vehicleType, String city, AreaType areaType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.city = city;
        this.areaType = areaType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public AreaType getAreaType() {
        return areaType;
    }

    public void setAreaType(AreaType areaType) {
        this.areaType = areaType;
    }
}
