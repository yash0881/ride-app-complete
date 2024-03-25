package com.rideapp.rideapp.rideBooking.ride;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RideRepository extends JpaRepository<RideEntity, Integer> {

    List<RideEntity> findByUserIdAndRideStatus(int userId, RideStatus rideStatus);
}
