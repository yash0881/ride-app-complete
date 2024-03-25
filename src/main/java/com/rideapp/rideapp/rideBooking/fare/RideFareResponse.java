package com.rideapp.rideapp.rideBooking.fare;

import com.rideapp.rideapp.vehicleConfiguration.VehicleType;

public class RideFareResponse {

    private VehicleType vehicleType;
    private double fare;

    public RideFareResponse() {
    }

    public RideFareResponse(VehicleType vehicleType, double fare) {
        this.vehicleType = vehicleType;
        this.fare = fare;
    }


    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }
}
