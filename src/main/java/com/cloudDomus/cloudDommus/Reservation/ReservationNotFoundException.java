package com.cloudDomus.cloudDommus.Reservation;

public class ReservationNotFoundException extends RuntimeException {

    ReservationNotFoundException(Long id) {
        super("Could not find work with id:  " + id);
    }

}
