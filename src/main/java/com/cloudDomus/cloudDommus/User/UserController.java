package com.cloudDomus.cloudDommus.User;

import com.cloudDomus.cloudDommus.Client.Client;
import com.cloudDomus.cloudDommus.Client.ClientRepository;
import com.cloudDomus.cloudDommus.LoadDatabase;
import com.cloudDomus.cloudDommus.Manager.Manager;
import com.cloudDomus.cloudDommus.Manager.ManagerRepository;
import com.cloudDomus.cloudDommus.Worker.Worker;
import com.cloudDomus.cloudDommus.Worker.WorkerRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Api(value="CloudDomus User Management System")
public class UserController {

    @Autowired
    UserRepository repository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    WorkerRepository workerRepository;

    @Autowired
    ManagerRepository managerRepository;

    private final Logger log =  LoggerFactory.getLogger(LoadDatabase.class);


    // Aggregate root
    @ApiOperation(value = "Login Validation", response = List.class)
    @PostMapping("/login")
    public String loginValidation(@RequestBody String params) throws JSONException {

        JSONObject param= new JSONObject(params);

        String email = (String) param.get("email");
        String password = (String) param.get("password");

        JSONObject response = new JSONObject();


        if(clientRepository.findByEmail(email) != null){
            Client user = clientRepository.findByEmail(email);
            if (user.getPassword().equals(password))
                response.put("userType", "client");
                response.put("user_id", user.getId());
        }
        else if(managerRepository.findByEmail(email) != null){
            Manager user = managerRepository.findByEmail(email);
            if (user.getPassword().equals(password))
                response.put("userType", "manager");
                response.put("user_id", user.getId());
        }
        else if(workerRepository.findByEmail(email) != null){
            Worker user = workerRepository.findByEmail(email);
            if (user.getPassword().equals(password))
                response.put("userType", "worker");
                response.put("user_id", user.getId());
        }
        else {
            response.put("error", "Invalid Credentials or User not registered!");
        }

        return response.toString();
    }

    public UserRepository getRepository() {
        return repository;
    }

    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    public ClientRepository getClientRepository() {
        return clientRepository;
    }

    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public WorkerRepository getWorkerRepository() {
        return workerRepository;
    }

    public void setWorkerRepository(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public ManagerRepository getManagerRepository() {
        return managerRepository;
    }

    public void setManagerRepository(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }
    
    

}
