package com.rideapp.rideapp.rideBooking.ride;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RideRepository extends JpaRepository<RideEntity, Integer> {

    List<RideEntity> findByUserIdAndRideStatus(int userId, RideStatus rideStatus);

    Optional<RideEntity> findByUserId(int userId);
}
