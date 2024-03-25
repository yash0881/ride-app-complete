package com.rideapp.rideapp.rideBooking.fare;

import jakarta.persistence.EmbeddedId;

public class Fare {


    @EmbeddedId
    private FareId fareId;
    private float baseFare;
    private float perStopFare;
    private float perKmFare;
    private float peakFare;

}
