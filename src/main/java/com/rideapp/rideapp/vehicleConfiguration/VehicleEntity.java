package com.rideapp.rideapp.vehicleConfiguration;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

@Entity
@Table(name = "vehicle")
public class VehicleEntity {
    @EmbeddedId
    private VehicleId vehicleId;

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

    public VehicleEntity(VehicleId vehicleId, boolean isAvailable, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.vehicleId = vehicleId;
        this.isAvailable = isAvailable;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public VehicleId getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(VehicleId vehicleId) {
        this.vehicleId = vehicleId;
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
