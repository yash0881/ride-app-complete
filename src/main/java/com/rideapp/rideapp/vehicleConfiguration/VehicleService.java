package com.rideapp.rideapp.vehicleConfiguration;

import java.util.Optional;

public interface VehicleService {

    Vehicle addVehicle(Vehicle vehicle);

    void markAvailableAsTrue(String vehicleNumber);

    VehicleEntity getVehicleNumber(VehicleType vehicleType, String city, AreaType areaType);

}
