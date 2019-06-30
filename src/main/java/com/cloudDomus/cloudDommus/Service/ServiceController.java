package com.cloudDomus.cloudDommus.Service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@RestController
@RequestMapping("/api/services")
@Api(value="CloudDomus Service Management System")
public class ServiceController {

    @Autowired
    ServiceRepository repository;

    // Aggregate root
    @ApiOperation(value = "View a list of available Service", response = List.class)
    @GetMapping("/service")
    public List<Service> all() {
        return repository.findAll();
    }

    @ApiOperation(value = "Create a new service", response = List.class)
    @PostMapping("/service")
    public Service newService(@RequestBody Service newService) {
        return repository.save(newService);
    }

    // Single item
    @ApiOperation(value = "Get service by Id", response = List.class)
    @GetMapping("/service/{id}")
    public Service getServiceByID(@PathVariable Long id) {

        return repository.findByID(id);
    }

    @ApiOperation(value = "Delete a service by its Id", response = List.class)
    @DeleteMapping("/Service/{id}")
    @Transactional(rollbackFor = ServiceNotFoundException.class)
    public Service deleteService(@PathVariable Long id) throws ServiceNotFoundException{
        Service deleted = repository.findByID(id);
        if(deleted == null){
            throw new ServiceNotFoundException(id);
        }
        repository.deleteById(id);
        deleted.setId(null);
        return deleted;
    }

    public void setRepository(ServiceRepository repository) {
        this.repository = repository;
    }
    
    
}
