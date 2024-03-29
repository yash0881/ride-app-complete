package com.rideapp.rideapp.rideBooking.vehicleAvailabilityMap;

import com.rideapp.rideapp.vehicleConfiguration.AreaType;
import com.rideapp.rideapp.rideBooking.vehicleAvailabilityMap.VehicleMapId;
import com.rideapp.rideapp.vehicleConfiguration.VehicleType;
import jakarta.persistence.*;


@Entity
@Table(name = "vehicle_map")
public class VehicleAvailabilityMapEntity {


    @EmbeddedId
    private VehicleMapId vehicleMapId;
    private int count;


    public VehicleAvailabilityMapEntity() {
    }

    public VehicleAvailabilityMapEntity(VehicleMapId vehicleMapId, int count) {
        this.vehicleMapId = vehicleMapId;
        this.count = count;
    }

    public VehicleMapId getVehicleMapId() {
        return vehicleMapId;
    }

    public void setVehicleMapId(VehicleMapId vehicleMapId) {
        this.vehicleMapId = vehicleMapId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
