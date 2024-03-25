package com.rideapp.rideapp.rideBooking.ride;

import com.rideapp.rideapp.rideBooking.fare.RideFareRequest;
import com.rideapp.rideapp.rideBooking.fare.RideFareResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;



@RestController
public class RideController {


    @Autowired
    private final RideService rideService;

    public RideController(RideService rideService) {
        this.rideService = rideService;
    }


//    @GetMapping("/isAvailable")
//    List<RideFareResponse> checkAvailability(@RequestBody RideFareRequest request){
//        return  rideService.getAvailableVehiclesWithFare(request);
//    }
//
//
//    @GetMapping("/start")
//    RideStartResponse startRide(@RequestBody RideStartRequest request){
//        return rideService.startRide(request);
//    }

    @GetMapping("/isAvailable")
    public ResponseEntity<List<RideFareResponse>> checkAvailability(@RequestBody RideFareRequest request) {
        try {
            List<RideFareResponse> availableRides = rideService.getAvailableVehiclesWithFare(request);
            return ResponseEntity.ok().body(availableRides);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/start")
    public ResponseEntity<RideStartResponse> startRide(@RequestBody RideStartRequest request) {
        try {
            RideStartResponse startResponse = rideService.startRide(request);
            return ResponseEntity.ok().body(startResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


}
