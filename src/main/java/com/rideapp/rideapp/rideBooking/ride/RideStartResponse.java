package com.rideapp.rideapp.rideBooking.ride;

import com.rideapp.rideapp.vehicleConfiguration.VehicleType;

public class RideStartResponse {
    private int rideId;
    private String vehicleNumber;
    private VehicleType vehicleType;
    private String message;


    public RideStartResponse() {
    }

    public RideStartResponse(int rideId, String vehicleNumber, VehicleType vehicleType, String message) {
        this.rideId = rideId;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.message=message;
    }

    public int getRideId() {
        return rideId;
    }

    public void setRideId(int rideId) {
        this.rideId = rideId;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}