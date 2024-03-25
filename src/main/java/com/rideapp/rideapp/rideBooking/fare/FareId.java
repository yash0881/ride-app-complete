package com.rideapp.rideapp.rideBooking.fare;

import com.rideapp.rideapp.vehicleConfiguration.AreaType;
import com.rideapp.rideapp.vehicleConfiguration.VehicleType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.io.Serializable;

public class FareId implements Serializable {


    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    @Enumerated(EnumType.STRING)
    private AreaType areaType;

}
