package com.rideapp.rideapp.rideBooking.ride;

public class CustomResponseMessage {

    private  String message;


    public CustomResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
