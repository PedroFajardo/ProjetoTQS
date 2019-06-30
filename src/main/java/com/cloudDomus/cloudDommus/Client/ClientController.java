package com.cloudDomus.cloudDommus.Client;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RestController
@RequestMapping("/api/clients")
@Api(value="CloudDomus Client Management System")
public class ClientController {

    @Autowired
    ClientRepository repository;

    // Aggregate root
    @ApiOperation(value = "View a list of available Client", response = List.class)
    @GetMapping("/client")
    public List<Client> all() {
        return repository.findAll();
    }

    @ApiOperation(value = "Create a new client", response = List.class)
    @PostMapping("/client")
    public Client newClient(@RequestBody Client newClient) {
        return repository.save(newClient);
    }

    // Single item
    @ApiOperation(value = "Get client by Id", response = List.class)
    @GetMapping("/client/{id}")
    public Client getClientByID(@PathVariable Long id) {

        return repository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
    }

    @ApiOperation(value = "Delete a work by its Id", response = List.class)
    @DeleteMapping("/Client/{id}")
    public void deleteClient(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
