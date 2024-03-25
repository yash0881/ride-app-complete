package com.rideapp.rideapp.rideBooking.fare;

import com.rideapp.rideapp.vehicleConfiguration.AreaType;
import com.rideapp.rideapp.vehicleConfiguration.VehicleType;

import java.util.List;

public interface FareService {

    List<FareEntity> getFare(VehicleType vehicleType, AreaType areaType);
}
