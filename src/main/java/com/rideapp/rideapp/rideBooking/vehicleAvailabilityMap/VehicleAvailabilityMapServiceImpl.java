package com.rideapp.rideapp.rideBooking.vehicleAvailabilityMap;

import com.rideapp.rideapp.vehicleConfiguration.AreaType;
import com.rideapp.rideapp.vehicleConfiguration.VehicleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VehicleAvailabilityMapServiceImpl implements VehicleAvailabilityMapService{

    private final VehicleAvailabilityMapRepository vehicleAvailabilityMapRepository;


    @Autowired
    public VehicleAvailabilityMapServiceImpl(VehicleAvailabilityMapRepository vehicleAvailabilityMapRepository) {
        this.vehicleAvailabilityMapRepository = vehicleAvailabilityMapRepository;
    }


    @Override
    public void increaseCountOfVehicle(VehicleType vehicleType, String city, AreaType areaType) {
        VehicleAvailabilityMapEntity vehicleAvailabilityMap = vehicleAvailabilityMapRepository.findByVehicleMapId_VehicleTypeAndVehicleMapId_CityAndVehicleMapId_AreaType(vehicleType, city, areaType);
        int currentCount = vehicleAvailabilityMap.getCount();
        if (currentCount >= 0) {
            vehicleAvailabilityMap.setCount(currentCount + 1);
        }
        vehicleAvailabilityMapRepository.save(vehicleAvailabilityMap);
    }

    @Override
    public void decreaseCountOfVehicle(VehicleType vehicleType, String city, AreaType areaType) {
        VehicleAvailabilityMapEntity vehicleAvailabilityMap = vehicleAvailabilityMapRepository.findByVehicleMapId_VehicleTypeAndVehicleMapId_CityAndVehicleMapId_AreaType(vehicleType, city, areaType);
        int currentCount = vehicleAvailabilityMap.getCount();
        if (currentCount > 0) {
            vehicleAvailabilityMap.setCount(currentCount - 1);
        }
        vehicleAvailabilityMapRepository.save(vehicleAvailabilityMap);
    }
}
