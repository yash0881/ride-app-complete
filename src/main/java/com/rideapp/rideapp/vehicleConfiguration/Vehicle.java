package com.rideapp.rideapp.vehicleConfiguration;

import java.time.LocalDateTime;



public class Vehicle {


    private String vehicleNumber;
    private VehicleType vehicleType;
    private String city;
    private AreaType areaType;
    private boolean isAvailable;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public Vehicle() {
    }

    public Vehicle(String vehicleNumber, VehicleType vehicleType, String city, AreaType areaType, boolean isAvailable, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.city = city;
        this.areaType = areaType;
        this.isAvailable = isAvailable;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
