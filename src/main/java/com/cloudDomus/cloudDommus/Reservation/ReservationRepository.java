package com.cloudDomus.cloudDommus.Reservation;

import com.cloudDomus.cloudDommus.Client.Client;
import com.cloudDomus.cloudDommus.Worker.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> getByClient(Client client);

}
