package com.cloudDomus.cloudDommus.Service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
@Api(value="CloudDomus Service Management System")
public class ServiceController {

    @Autowired
    ServiceRepository repository;

    // Aggregate root
    @ApiOperation(value = "View a list of available Service", response = List.class)
    @GetMapping("/service")
    List<Service> all() {
        return repository.findAll();
    }

    @ApiOperation(value = "Create a new service", response = List.class)
    @PostMapping("/service")
    Service newService(@RequestBody Service newService) {
        return repository.save(newService);
    }

    // Single item
    @ApiOperation(value = "Get service by Id", response = List.class)
    @GetMapping("/service/{id}")
    Service getServiceByID(@PathVariable Long id) {

        return repository.findById(id).orElseThrow(() -> new ServiceNotFoundException(id));
    }

   /* @ApiOperation(value = "Edit/Replace a service by its Id", response = List.class)
    @PutMapping("/Service/{id}")
    Service replaceService(@RequestBody Service newservice, @PathVariable Long id) {

        return repository.findById(id)
                .map(service -> {
                    service.setName(newservice.getName());
                    service.setNumberWorkers(newservice.getNumberWorkers());
                    service.setDescription(newservice.getDescription());
                    return repository.save(service);
                })
                .orElseGet(() -> {
                    newservice.setId(id);
                    return repository.save(newservice;
                });
    }*/

    @ApiOperation(value = "Delete a service by its Id", response = List.class)
    @DeleteMapping("/Service/{id}")
    void deleteService(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
