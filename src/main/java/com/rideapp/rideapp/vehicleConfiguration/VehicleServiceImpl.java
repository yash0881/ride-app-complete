
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


    @Autowired
    private final VehicleRepository vehicleRepository;

    @Autowired
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

        // adding the details of new object
        VehicleId vehicleId = new VehicleId();
        vehicleId.setVehicleNumber(vehicle.getVehicleNumber());
        vehicleId.setVehicleType(vehicle.getVehicleType());
        vehicleId.setCity(vehicle.getCity());
        vehicleId.setAreaType(vehicle.getAreaType());

        vehicleEntity.setVehicleId(vehicleId);

        vehicleEntity.setIsAvailable(vehicle.getIsAvailable());
        vehicleEntity.setCreatedAt(LocalDateTime.now());
        vehicleEntity.setUpdatedAt(LocalDateTime.now());

        String veh_num = vehicleEntity.getVehicleId().getVehicleNumber();
        Optional<VehicleEntity> isPresent = vehicleRepository.findByVehicleId_VehicleNumber(veh_num);

        if(isPresent.isEmpty()){
            // increasing the count of new vehicle in map if it is not a modification request
            if(vehicle.getIsAvailable()) {
                vehicleAvailabilityMapService.increaseCountOfVehicle(vehicleEntity.getVehicleId().getVehicleType(), vehicleEntity.getVehicleId().getCity(), vehicleEntity.getVehicleId().getAreaType());
            }
        }else {
            vehicleAvailabilityMapService.decreaseCountOfVehicle(vehicleEntity.getVehicleId().getVehicleType(), vehicleEntity.getVehicleId().getCity(), vehicleEntity.getVehicleId().getAreaType());
        }

        // saving the new object of vehicle in vehicle table
        VehicleEntity savedEntity = vehicleRepository.save(vehicleEntity);




        return new Vehicle(savedEntity.getVehicleId().getVehicleNumber(), savedEntity.getVehicleId().getVehicleType(), savedEntity.getVehicleId().getCity(), savedEntity.getVehicleId().getAreaType(), savedEntity.getIsAvailable(), savedEntity.getCreatedAt(), savedEntity.getUpdatedAt());
    }




    @Override
    public VehicleEntity getVehicleNumber(VehicleType vehicleType, String city, AreaType areaType) {
        List<VehicleEntity> vehicleEntity =  vehicleRepository.findByVehicleId_VehicleTypeAndVehicleId_CityAndVehicleId_AreaTypeAndIsAvailableTrue(vehicleType,city, areaType);
        vehicleEntity.get(0).setIsAvailable(false);
        vehicleRepository.save(vehicleEntity.get(0));
        return vehicleEntity.get(0);
    }

    @Override
    public void markAvailableAsTrue(String vehicleNumber, VehicleType vehicleType, String city, AreaType areaType) {
        Optional<VehicleEntity> vehicleEntity = vehicleRepository.findByVehicleId_VehicleNumber(vehicleNumber);
        VehicleEntity vehicle = vehicleEntity.get();
        vehicle.setIsAvailable(true);
        vehicleRepository.save(vehicle);
    }
}


