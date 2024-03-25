package com.rideapp.rideapp.rideBooking.fare;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;



@Entity
@Table(name = "fare")
public class FareEntity {


    @EmbeddedId
    private FareId fareId;
    private float baseFare;
    private float perStopFare;
    private float perKmFare;
    private float peakFare;

    public FareEntity() {
    }

    public FareEntity(FareId fareId, float baseFare, float perStopFare, float perKmFare, float peakFare) {
        this.fareId = fareId;
        this.baseFare = baseFare;
        this.perStopFare = perStopFare;
        this.perKmFare = perKmFare;
        this.peakFare = peakFare;
    }

    public FareId getFareId() {
        return fareId;
    }

    public void setFareId(FareId fareId) {
        this.fareId = fareId;
    }

    public float getBaseFare() {
        return baseFare;
    }

    public void setBaseFare(float baseFare) {
        this.baseFare = baseFare;
    }

    public float getPerStopFare() {
        return perStopFare;
    }

    public void setPerStopFare(float perStopFare) {
        this.perStopFare = perStopFare;
    }

    public float getPerKmFare() {
        return perKmFare;
    }

    public void setPerKmFare(float perKmFare) {
        this.perKmFare = perKmFare;
    }

    public float getPeakFare() {
        return peakFare;
    }

    public void setPeakFare(float peakFare) {
        this.peakFare = peakFare;
    }
}
