package com.rideapp.rideapp.vehicleConfiguration;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

@Entity
@Table(name = "vehicle")
public class VehicleEntity {

    @Id
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

    @Value("false")
    @Column(name = "isAvailable")
    private boolean isAvailable;

    @CreationTimestamp
    @Column(name = "createdAt")
    private LocalDateTime createdAt;


    @UpdateTimestamp
    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

    public VehicleEntity() {
    }

    public VehicleEntity(String vehicleNumber, VehicleType vehicleType, String city, AreaType areaType, boolean isAvailable, LocalDateTime createdAt, LocalDateTime updatedAt) {
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

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
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
