package com.cloudDomus.cloudDommus.Reservation;

import com.cloudDomus.cloudDommus.Client.Client;
import com.cloudDomus.cloudDommus.Client.ClientController;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

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

    @Autowired
    ClientController clientController;

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
        String description = (String) param.get("description");
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date startHour = dateFormat.parse(param.get("startHour").toString());
        Date endHour = dateFormat.parse(param.get("endHour").toString());

        double priceHour = Double.parseDouble(param.get("priceHour").toString());
        String user_id = param.get("user_id").toString();

        Reservation reservation = new Reservation(description, startHour, endHour, priceHour);

        for (int i = 0; i < services.length(); i++) {
            reservation.addService(serviceController.getServiceByID(services.getLong(i)));
        }

        Worker worker = workerController.getWorkerByID(Long.parseLong(user_id));

        reservation.setWorker(worker);

        return repository.save(reservation);

    }

    @ApiOperation(value = "Get reservation by Id", response = List.class)
    @GetMapping("/reservation/{id}")
    public Reservation getReservationByID(@PathVariable Long id) {
        return repository.getById(id);
    }

    @ApiOperation(value = "Get reservations by Worker Id", response = List.class)
    @GetMapping("/reservation/worker/{id}")
    public List<Reservation> getReservationsByWorkerID(@PathVariable Long id) {

        Worker worker = workerController.getWorkerByID(id);

        return worker.getReservations();
    }

    @ApiOperation(value = "Get reservations by Client Id", response = List.class)
    @GetMapping("/reservation/client/{id}")
    public List<Reservation> getReservationsByClientID(@PathVariable Long id) {

        return repository.getByClient(clientController.getClientByID(id));
    }


    @ApiOperation(value = "Delete a reservation by its Id", response = List.class)
    @DeleteMapping("/reservation/{id}")
    @Transactional(rollbackFor = ReservationNotFoundException.class)
    public Reservation deleteReservation(@PathVariable Long id) {
        Reservation deleted = repository.getById(id);
        if(deleted == null){
            throw new ReservationNotFoundException(id);
        }
        repository.deleteById(id);
        deleted.setId(null);
        return deleted;
    }

    public ReservationRepository getRepository() {
        return repository;
    }

    public void setRepository(ReservationRepository repository) {
        this.repository = repository;
    }

    public ServiceController getServiceController() {
        return serviceController;
    }

    public void setServiceController(ServiceController serviceController) {
        this.serviceController = serviceController;
    }

    public WorkerController getWorkerController() {
        return workerController;
    }

    public void setWorkerController(WorkerController workerController) {
        this.workerController = workerController;
    }

    public UserController getUserController() {
        return userController;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }

    public ClientController getClientController() {
        return clientController;
    }

    public void setClientController(ClientController clientController) {
        this.clientController = clientController;
    }

}
