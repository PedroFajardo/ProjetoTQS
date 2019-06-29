package com.cloudDomus.cloudDommus.Reservation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@Api(value="CloudDomus Reservation Management System")
public class ReservationController {
    
    @Autowired
    ReservationRepository repository;

    // Aggregate root
    @ApiOperation(value = "View a list of available Reservation", response = List.class)
    @GetMapping("/reservation")
    public List<Reservation> all() {
        return repository.findAll();
    }

    @ApiOperation(value = "Create a new reservation", response = List.class)
    @PostMapping("/reservation")
    public Reservation newReservation(@RequestBody Reservation newReservation) {
        return repository.save(newReservation);
    }

    // Single item
    @ApiOperation(value = "Get reservation by Id", response = List.class)
    @GetMapping("/reservation/{id}")
    public Reservation getReservationByID(@PathVariable Long id) {

        return repository.findById(id).orElseThrow(() -> new ReservationNotFoundException(id));
    }

    @ApiOperation(value = "Delete a reservation by its Id", response = List.class)
    @DeleteMapping("/Reservation/{id}")
    public void deleteReservation(@PathVariable Long id) {
        repository.deleteById(id);
    }


}
