package com.rideapp.rideapp.rideBooking.vehicleAvailabilityMap;

import com.rideapp.rideapp.vehicleConfiguration.AreaType;
import com.rideapp.rideapp.vehicleConfiguration.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleAvailabilityMapRepository extends JpaRepository<VehicleAvailabilityMapEntity, VehicleMapId> {

    List<VehicleAvailabilityMapEntity> findByVehicleMapId_CityAndVehicleMapId_AreaTypeAndCountGreaterThan(String city, AreaType areaType, int count);

    VehicleAvailabilityMapEntity findByVehicleMapId_VehicleTypeAndVehicleMapId_CityAndVehicleMapId_AreaType(VehicleType vehicleType, String city, AreaType areaType);
}