package com.rideapp.rideapp.vehicleConfiguration;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends JpaRepository<VehicleEntity, VehicleId> {

    List<VehicleEntity> findByVehicleId_VehicleTypeAndVehicleId_CityAndVehicleId_AreaTypeAndIsAvailableTrue(VehicleType vehicleType, String city, AreaType areaType);

    Optional<VehicleEntity> findByVehicleId_VehicleNumber(String vehicleNumber);

}
