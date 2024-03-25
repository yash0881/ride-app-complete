package com.rideapp.rideapp.rideBooking.fare;

import com.rideapp.rideapp.vehicleConfiguration.AreaType;


public class RideFareRequest {

    private int userId;
    private String city;
    private AreaType areaType;
    private float distance;
    private int stops;
    private boolean isPeak;

    public RideFareRequest() {
    }

    public RideFareRequest(int userId, String city, AreaType areaType, float distance, int stops, boolean isPeak) {
        this.userId = userId;
        this.city = city;
        this.areaType = areaType;
        this.distance = distance;
        this.stops = stops;
        this.isPeak = isPeak;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public int getStops() {
        return stops;
    }

    public void setStops(int stops) {
        this.stops = stops;
    }

    public boolean isPeak() {
        return isPeak;
    }

    public void setIsPeak(boolean isPeak) {
        this.isPeak = isPeak;
    }
}
