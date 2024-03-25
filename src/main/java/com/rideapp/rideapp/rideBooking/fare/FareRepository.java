package com.rideapp.rideapp.rideBooking.fare;

import com.rideapp.rideapp.vehicleConfiguration.AreaType;
import com.rideapp.rideapp.vehicleConfiguration.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FareRepository extends JpaRepository<FareEntity, FareId> {
    List<FareEntity> getByFareId_VehicleTypeAndFareId_AreaType(VehicleType vehicleType, AreaType areaType);
}
