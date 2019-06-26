package com.cloudDomus.cloudDommus.Client;

import java.util.List;

import com.cloudDomus.cloudDommus.Client.ClientRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
@Api(value="CloudDomus Client Management System")
public class ClientController {

    @Autowired
    ClientRepository repository;

    // Aggregate root
    @ApiOperation(value = "View a list of available Client", response = List.class)
    @GetMapping("/client")
    List<Client> all() {
        return repository.findAll();
    }

    @ApiOperation(value = "Create a new client", response = List.class)
    @PostMapping("/client")
    Client newClient(@RequestBody Client newClient) {
        return repository.save(newClient);
    }

    // Single item
    @ApiOperation(value = "Get client by Id", response = List.class)
    @GetMapping("/client/{id}")
    Client getClientByID(@PathVariable Long id) {

        return repository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
    }

   /* @ApiOperation(value = "Edit/Replace a client by its Id", response = List.class)
    @PutMapping("/Client/{id}")
    Client replaceClient(@RequestBody Client newclient, @PathVariable Long id) {

        return repository.findById(id)
                .map(client -> {
                    client.setName(newclient.getName());
                    client.setNumberWorkers(newclient.getNumberWorkers());
                    client.setDescription(newclient.getDescription());
                    return repository.save(client);
                })
                .orElseGet(() -> {
                    newclient.setId(id);
                    return repository.save(newclient;
                });
    }*/

    @ApiOperation(value = "Delete a work by its Id", response = List.class)
    @DeleteMapping("/Client/{id}")
    void deleteClient(@PathVariable Long id) {
        repository.deleteById(id);
    }


}
