package com.cloudDomus.cloudDommus.Reservation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Reservation findByID(Long id);

}