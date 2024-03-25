package com.rideapp.rideapp.rideBooking.vehicleAvailabilityMap;


import com.rideapp.rideapp.vehicleConfiguration.AreaType;
import com.rideapp.rideapp.vehicleConfiguration.VehicleType;

public interface VehicleAvailabilityMapService {

   void decreaseCountOfVehicle(VehicleType vehicleType, String city, AreaType areaType);

    void increaseCountOfVehicle(VehicleType vehicleType, String city, AreaType areaType);


}
