package com.rideapp.rideapp.rideBooking.ride;

import com.rideapp.rideapp.rideBooking.fare.FareEntity;
import com.rideapp.rideapp.rideBooking.fare.FareService;
import com.rideapp.rideapp.rideBooking.fare.RideFareRequest;
import com.rideapp.rideapp.rideBooking.fare.RideFareResponse;
import com.rideapp.rideapp.rideBooking.vehicleAvailabilityMap.VehicleAvailabilityMapEntity;
import com.rideapp.rideapp.rideBooking.vehicleAvailabilityMap.VehicleAvailabilityMapRepository;
import com.rideapp.rideapp.rideBooking.vehicleAvailabilityMap.VehicleAvailabilityMapService;
import com.rideapp.rideapp.vehicleConfiguration.AreaType;
import com.rideapp.rideapp.vehicleConfiguration.VehicleEntity;
import com.rideapp.rideapp.vehicleConfiguration.VehicleService;
import com.rideapp.rideapp.vehicleConfiguration.VehicleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class RideServiceImpl implements RideService{


    @Autowired
    private final  RideRepository rideRepository;
    @Autowired
    private final VehicleAvailabilityMapRepository vehicleAvailabilityMapRepository;
    @Autowired
    private final FareService fareService;

    @Autowired
    private final VehicleService vehicleService;

    @Autowired
    private final VehicleAvailabilityMapService vehicleAvailabilityMapService;

    public RideServiceImpl(RideRepository rideRepository, VehicleAvailabilityMapRepository vehicleAvailabilityMapRepository, FareService fareService, VehicleService vehicleService, VehicleAvailabilityMapService vehicleAvailabilityMapService) {
        this.rideRepository = rideRepository;
        this.vehicleAvailabilityMapRepository = vehicleAvailabilityMapRepository;
        this.fareService = fareService;
        this.vehicleService = vehicleService;
        this.vehicleAvailabilityMapService = vehicleAvailabilityMapService;
    }


    @Override
    public List<RideFareResponse> getAvailableVehiclesWithFare(RideFareRequest request) {
        String city = request.getCity();
        AreaType areaType = request.getAreaType();
        List<VehicleAvailabilityMapEntity> vehicleAvailabilityMapEntity = vehicleAvailabilityMapRepository.findByVehicleMapId_CityAndVehicleMapId_AreaTypeAndCountGreaterThan(city, areaType, 0);
        List<VehicleType> availableVehicles = new ArrayList<>();

        for(VehicleAvailabilityMapEntity entity : vehicleAvailabilityMapEntity){
            availableVehicles.add(entity.getVehicleMapId().getVehicleType());
        }

        return getAvailabilityWithFare(availableVehicles, request);
    }

    public List<RideFareResponse> getAvailabilityWithFare(List<VehicleType> availableVehicles, RideFareRequest request) {
        List<RideFareResponse> rideFareResponses = new ArrayList<>();
        for (VehicleType vehicle : availableVehicles) {
            List<FareEntity> fare = fareService.getFare(vehicle, request.getAreaType());
            if (!fare.isEmpty()) {
                FareEntity fareEntity = fare.get(0);
                double totalFare = calculateTotalFare(fareEntity, request.getDistance(), request.getStops(), request.isPeak());
                RideFareResponse rideFareResponse = new RideFareResponse(vehicle, totalFare);
                rideFareResponses.add(rideFareResponse);
            }
        }
        return rideFareResponses;
    }


    private double calculateTotalFare(FareEntity fare, float distance, int extraStops, boolean peakHours) {
        double baseFare = fare.getBaseFare();
        double farePerKm = fare.getPerKmFare();
        if(peakHours)
            baseFare+=fare.getPeakFare();
        return baseFare + (distance * farePerKm) + (extraStops * fare.getPerStopFare()) ;

    }


    @Override
    public RideStartResponse startRide(RideStartRequest request) {
            if(request.getRideId()>0){
                        vehicleService.markAvailableAsTrue(request.getVehicleNumber(), request.getVehicleType(),request.getCity(),request.getAreaType());
                        vehicleAvailabilityMapService.increaseCountOfVehicle(request.getVehicleType(), request.getCity(), request.getAreaType());
                        Optional<RideEntity> rideEntity = rideRepository.findById(request.getRideId());
                        RideEntity ride = rideEntity.get();
                        ride.setRideStatus(request.getRideStatus());
                        rideRepository.save(ride);
                        String message = "You ride has finished successfully";
                        return new RideStartResponse(ride.getRideId(), ride.getVehicleNumber(), ride.getVehicleType(), message, request.getTotalFare());
            }else {
                // Check if the user has an ongoing ride
                List<RideEntity> ongoingRides = rideRepository.findByUserIdAndRideStatus(request.getUserId(), RideStatus.Ongoing);
                if (!ongoingRides.isEmpty()) {
                    String message = "You already have a ride in progress. Please complete your current ride before booking another one.";
                    return new RideStartResponse(message);
                } else {
                    VehicleEntity vehicleEntity = vehicleService.getVehicleNumber(request.getVehicleType(), request.getCity(), request.getAreaType());
                    String vehicleNumber = vehicleEntity.getVehicleId().getVehicleNumber();
                    vehicleAvailabilityMapService.decreaseCountOfVehicle(request.getVehicleType(), request.getCity(), request.getAreaType());
                    RideEntity rideEntity = addDetailsToRideTable(request, vehicleNumber);
                    String message = "Your ride has started successfully";
                    return new RideStartResponse(rideEntity.getRideId(), rideEntity.getVehicleNumber(), rideEntity.getVehicleType(), message, request.getTotalFare());
                }
            }
    }


    public RideEntity addDetailsToRideTable(RideStartRequest request, String vehicleNumber){

        RideEntity rideEntity = new RideEntity();

        rideEntity.setUserId(request.getUserId());
        rideEntity.setDistance(request.getDistance());
        rideEntity.setStops(request.getStops());
        rideEntity.setRideStatus(request.getRideStatus());
        rideEntity.setVehicleNumber(vehicleNumber);
        rideEntity.setVehicleType(request.getVehicleType());
        rideEntity.setAreaType(request.getAreaType());
        rideEntity.setCity(request.getCity());
        rideEntity.setPeak(request.isPeak());
        rideEntity.setTotalFare(request.getTotalFare());

        return rideRepository.save(rideEntity);
    }


}
