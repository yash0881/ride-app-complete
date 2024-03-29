package com.rideapp.rideapp.rideBooking.ride;

import com.rideapp.rideapp.rideBooking.fare.RideFareRequest;
import com.rideapp.rideapp.rideBooking.fare.RideFareResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class RideController {


    private final RideService rideService;

    @Autowired
    public RideController(RideService rideService) {
        this.rideService = rideService;
    }


    @GetMapping("/availability")
    public ResponseEntity<?> checkAvailability(@RequestBody RideFareRequest request) {
        try {
            List<RideFareResponse> availableRides = rideService.getAvailableVehiclesWithFare(request);

            if (availableRides.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body(new CustomResponseMessage("No rides available"));
            } else {
                return ResponseEntity.ok().body(availableRides);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CustomResponseMessage("Server is down"));
        }
    }

    @PostMapping("/start")
    public ResponseEntity<RideStartResponse> startRide(@RequestBody RideStartRequest request) {
        try {
            RideStartResponse startResponse = rideService.startRide(request);
            return ResponseEntity.ok().body(startResponse);
        } catch (InvalidRequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RideStartResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PatchMapping("/end")
    public ResponseEntity<?> endRide(@RequestBody RideStartRequest request) {
        try {
            RideStartResponse startResponse = rideService.endRide(request);
            return ResponseEntity.ok().body(startResponse);
        } catch (InvalidRequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CustomResponseMessage(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CustomResponseMessage("Server is down"));
        }
    }






}
