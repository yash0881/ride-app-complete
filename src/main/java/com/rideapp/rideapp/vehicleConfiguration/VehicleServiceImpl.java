
package com.rideapp.rideapp.vehicleConfiguration;

import com.rideapp.rideapp.rideBooking.vehicleAvailabilityMap.VehicleAvailabilityMapService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {


    private final VehicleRepository vehicleRepository;

    private final VehicleAvailabilityMapService vehicleAvailabilityMapService;



    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository, VehicleAvailabilityMapService vehicleAvailabilityMapService) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleAvailabilityMapService = vehicleAvailabilityMapService;
    }

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {

        // creating the new object of vehicle
        VehicleEntity vehicleEntity = new VehicleEntity();

        vehicleEntity.setVehicleNumber(vehicle.getVehicleNumber());
        vehicleEntity.setVehicleType(vehicle.getVehicleType());
        vehicleEntity.setCity(vehicle.getCity());
        vehicleEntity.setAreaType(vehicle.getAreaType());

        vehicleEntity.setCreatedAt(LocalDateTime.now());

        vehicleEntity.setIsAvailable(vehicle.getIsAvailable());


        String veh_num = vehicleEntity.getVehicleNumber();
        Optional<VehicleEntity> isPresent = vehicleRepository.findByVehicleNumber(veh_num);

        if(isPresent.isEmpty() && vehicle.getIsAvailable()){
            // increasing the count of new vehicle in map if it is not a modification request
                vehicleEntity.setCreatedAt(LocalDateTime.now());
                vehicleEntity.setUpdatedAt(LocalDateTime.now());
                vehicleAvailabilityMapService.increaseCountOfVehicle(vehicleEntity.getVehicleType(), vehicleEntity.getCity(), vehicleEntity.getAreaType());
        }else if(isPresent.isEmpty() && !vehicle.getIsAvailable()){
            vehicleEntity.setCreatedAt(LocalDateTime.now());
            vehicleEntity.setUpdatedAt(LocalDateTime.now());
        }else if(isPresent.get().getIsAvailable() && !vehicle.getIsAvailable()) {
            vehicleEntity.setCreatedAt(isPresent.get().getCreatedAt());
            vehicleEntity.setUpdatedAt(LocalDateTime.now());
            vehicleAvailabilityMapService.decreaseCountOfVehicle(vehicleEntity.getVehicleType(), vehicleEntity.getCity(), vehicleEntity.getAreaType());
        }else if(!isPresent.get().getIsAvailable() && vehicle.getIsAvailable()){
            vehicleEntity.setCreatedAt(isPresent.get().getCreatedAt());
            vehicleEntity.setUpdatedAt(LocalDateTime.now());
            vehicleAvailabilityMapService.increaseCountOfVehicle(vehicleEntity.getVehicleType(), vehicleEntity.getCity(), vehicleEntity.getAreaType());
        }

        // saving the new object of vehicle in vehicle table
        VehicleEntity savedEntity = vehicleRepository.save(vehicleEntity);

        return new Vehicle(savedEntity.getVehicleNumber(), savedEntity.getVehicleType(), savedEntity.getCity(), savedEntity.getAreaType(), savedEntity.getIsAvailable(), savedEntity.getCreatedAt(), savedEntity.getUpdatedAt());
    }


    @Override
    public VehicleEntity getVehicleNumber(VehicleType vehicleType, String city, AreaType areaType) {
        List<VehicleEntity> vehicleEntity =  vehicleRepository.findByVehicleTypeAndCityAndAreaTypeAndIsAvailableTrue(vehicleType,city, areaType);
        vehicleEntity.get(0).setIsAvailable(false);
        vehicleRepository.save(vehicleEntity.get(0));
        return vehicleEntity.get(0);
    }

    @Override
    public void markAvailableAsTrue(String vehicleNumber) {
        Optional<VehicleEntity> vehicleEntity = vehicleRepository.findByVehicleNumber(vehicleNumber);
        VehicleEntity vehicle = vehicleEntity.get();
        vehicle.setIsAvailable(true);
        vehicleRepository.save(vehicle);
    }
}


