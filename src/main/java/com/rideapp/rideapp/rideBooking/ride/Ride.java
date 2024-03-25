package com.rideapp.rideapp.rideBooking.ride;

import com.rideapp.rideapp.vehicleConfiguration.AreaType;
import com.rideapp.rideapp.vehicleConfiguration.VehicleType;

public class Ride {
    private  int rideId;
    private int userId;
    private float distance;
    private int stops;
    private String vehicleNumber;
    private VehicleType vehicleType;
    private AreaType areaType;
    private boolean isPeak;
    private String city;
    private double totalFare;

    public  Ride(){

    }

    public Ride(int rideId, int userId, float distance, int stops, String vehicleNumber, VehicleType vehicleType, AreaType areaType, boolean isPeak, String city, double totalFare) {
        this.rideId = rideId;
        this.userId = userId;
        this.distance = distance;
        this.stops = stops;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.areaType = areaType;
        this.isPeak = isPeak;
        this.city = city;
        this.totalFare = totalFare;
    }


    public int getRideId() {return rideId;}

    public void setRideId(int rideId) {this.rideId = rideId;}

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public int getStops() {return stops;}

    public void setStops(int stops) {
        this.stops = stops;
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

    public AreaType getAreaType() {
        return areaType;
    }

    public void setAreaType(AreaType areaType) {
        this.areaType = areaType;
    }

    public boolean getIsPeak() {
        return isPeak;
    }

    public void setPeak(boolean peak) {
        isPeak = peak;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(double totalFare) {
        this.totalFare = totalFare;
    }
}
