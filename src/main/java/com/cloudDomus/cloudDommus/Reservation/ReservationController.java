package com.cloudDomus.cloudDommus.Reservation;

import com.cloudDomus.cloudDommus.LoadDatabase;
import com.cloudDomus.cloudDommus.Service.Service;
import com.cloudDomus.cloudDommus.Service.ServiceController;
import com.cloudDomus.cloudDommus.User.UserController;
import com.cloudDomus.cloudDommus.User.UserRepository;
import com.cloudDomus.cloudDommus.Worker.Worker;
import com.cloudDomus.cloudDommus.Worker.WorkerController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@Api(value="CloudDomus Reservation Management System")
public class ReservationController {
    
    @Autowired
    ReservationRepository repository;

    @Autowired
    ServiceController serviceController;

    @Autowired
    WorkerController workerController;

    @Autowired
    UserController userController;

    private final Logger log =  LoggerFactory.getLogger(LoadDatabase.class);

    // Aggregate root
    @ApiOperation(value = "View a list of available Reservation", response = List.class)
    @GetMapping("/reservation")
    public List<Reservation> all() {
        return repository.findAll();
    }

    @ApiOperation(value = "Create a new reservation", response = List.class)
    @PostMapping("/reservation")
    public Reservation newReservation(@RequestBody String params) throws JSONException, ParseException {

        JSONObject param = new JSONObject(params);

        JSONArray services = param.getJSONArray("service");
        log.info(services.toString());
        String description = (String) param.get("description");
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date startHour = dateFormat.parse(param.get("startHour").toString());
        Date endHour = dateFormat.parse(param.get("endHour").toString());
        log.info(startHour.toString());
        log.info(endHour.toString());

        double priceHour = Double.parseDouble(param.get("priceHour").toString());
        log.info(String.valueOf(priceHour));
        String user_id = param.get("user_id").toString();
        log.info(user_id);

        Reservation reservation = new Reservation(description, startHour, endHour, priceHour);

        for (int i = 0; i < services.length(); i++) {
            reservation.addService(serviceController.getServiceByID(services.getLong(i)));
        }

        Worker worker = workerController.getWorkerByID(Long.parseLong(user_id));

        reservation.setWorker(worker);

        log.info(reservation.toString());
        return repository.save(reservation);

    }

    // Single item
    @ApiOperation(value = "Get reservation by Id", response = List.class)
    @GetMapping("/reservation/{id}")
    public Reservation getReservationByID(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ReservationNotFoundException(id));
    }

    @ApiOperation(value = "Get reservations by Worker Id", response = List.class)
    @GetMapping("/reservation/worker/{id}")
    public List<Reservation> getReservationsByUserID(@PathVariable Long id) {

        log.info("here");
        Worker worker = workerController.getWorkerByID(id);

        log.info(worker.getReservations().toString());

        return worker.getReservations();
    }


    @ApiOperation(value = "Delete a reservation by its Id", response = List.class)
    @DeleteMapping("/reservation/{id}")
    public void deleteReservation(@PathVariable Long id) {
        repository.deleteById(id);
    }


}
