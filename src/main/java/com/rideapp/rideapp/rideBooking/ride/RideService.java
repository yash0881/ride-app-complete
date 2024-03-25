package com.rideapp.rideapp.rideBooking.ride;

import com.rideapp.rideapp.rideBooking.fare.RideFareRequest;
import com.rideapp.rideapp.rideBooking.fare.RideFareResponse;
import com.rideapp.rideapp.rideBooking.vehicleAvailabilityMap.VehicleAvailabilityMapEntity;
import com.rideapp.rideapp.vehicleConfiguration.AreaType;
import com.rideapp.rideapp.vehicleConfiguration.VehicleType;

import java.util.List;

public interface RideService {

    List<RideFareResponse> getAvailableVehiclesWithFare(RideFareRequest request);

    RideStartResponse startRide(RideStartRequest request);
}
