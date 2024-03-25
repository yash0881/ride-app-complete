package com.rideapp.rideapp.rideBooking.vehicleAvailabilityMap;


import com.rideapp.rideapp.vehicleConfiguration.AreaType;
import com.rideapp.rideapp.vehicleConfiguration.VehicleType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public class VehicleMapId {

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private VehicleType vehicleType;

    @Column(length = 50)
    private String city;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private AreaType areaType;

    public VehicleMapId() {
    }

    public VehicleMapId(VehicleType vehicleType, String city, AreaType areaType) {
        this.vehicleType = vehicleType;
        this.city = city;
        this.areaType = areaType;
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
