package com.rideapp.rideapp.vehicleConfiguration;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends JpaRepository<VehicleEntity, String> {

    List<VehicleEntity> findByVehicleTypeAndCityAndAreaTypeAndIsAvailableTrue(VehicleType vehicleType, String city, AreaType areaType);

    Optional<VehicleEntity> findByVehicleNumber(String vehicleNumber);

}
