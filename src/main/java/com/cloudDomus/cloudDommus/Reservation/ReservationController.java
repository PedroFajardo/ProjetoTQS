package com.cloudDomus.cloudDommus.Reservation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

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
        return repository.findByID(id);
    }

    @ApiOperation(value = "Delete a reservation by its Id", response = List.class)
    @DeleteMapping("/Reservation/{id}")
    @Transactional(rollbackFor = ReservationNotFoundException.class)
    public Reservation deleteReservation(@PathVariable Long id) throws ReservationNotFoundException {
        Reservation deleted = repository.findByID(id);
        if(deleted == null){
            throw new ReservationNotFoundException(id);
        }
        repository.deleteById(id);
        deleted.setId(null);
        return repository.findByID(id);
    }

    public void setRepository(ReservationRepository repository) {
        this.repository = repository;
    }
    
    

}
