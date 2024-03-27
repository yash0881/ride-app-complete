package com.rideapp.rideapp.rideBooking.fare;


import com.rideapp.rideapp.vehicleConfiguration.AreaType;
import com.rideapp.rideapp.vehicleConfiguration.VehicleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FareServiceImpl implements FareService {



    private final FareRepository repository;



    @Autowired
    public FareServiceImpl(FareRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<FareEntity> getFare(VehicleType vehicleType, AreaType areaType) {
        return repository.getByFareId_VehicleTypeAndFareId_AreaType(vehicleType, areaType);
    }
}
