package com.rideapp.rideapp.rideBooking.ride;

import com.rideapp.rideapp.vehicleConfiguration.AreaType;
import com.rideapp.rideapp.vehicleConfiguration.VehicleType;
import org.aspectj.lang.annotation.RequiredTypes;

public class RideStartRequest {

    private int rideId;

    private int userId;
    private int distance;
    private int stops;
    private String city;
    private RideStatus rideStatus;
    private AreaType areaType;
    private boolean isPeak;
    private VehicleType vehicleType;
    private String vehicleNumber;
    private double totalFare;

    public RideStartRequest() {
    }

    public RideStartRequest(int rideId, int userId, int distance, int stops,RideStatus rideStatus, String vehicleNumber, String city, AreaType areaType, boolean isPeak, VehicleType vehicleType, int totalFare) {
        this.rideId=rideId;
        this.userId = userId;
        this.distance = distance;
        this.stops = stops;
        this.city = city;
        this.rideStatus=rideStatus;
        this.areaType = areaType;
        this.isPeak = isPeak;
        this.vehicleType = vehicleType;
        this.vehicleNumber=vehicleNumber;
        this.totalFare = totalFare;
    }

    public int getRideId() {
        return rideId;
    }

    public void setRideId(int rideId) {
        this.rideId = rideId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getStops() {
        return stops;
    }

    public RideStatus getRideStatus() {
        return rideStatus;
    }

    public void setRideStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
    }

    public void setStops(int stops) {
        this.stops = stops;
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

    public boolean isPeak() {
        return isPeak;
    }

    public void setIsPeak(boolean peak) {
        isPeak = peak;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public void setTotalFare(double totalFare) {
        this.totalFare = totalFare;
    }
}
