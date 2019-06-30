package com.cloudDomus.cloudDommus.Manager;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/managers")
@Api(value="CloudDomus Manager Management System")
public class ManagerController {

    @Autowired
    ManagerRepository repository;

    // Aggregate root
    @ApiOperation(value = "View a list of available Manager", response = List.class)
    @GetMapping("/manager")
    public List<Manager> all() {
        return repository.findAll();
    }

    @ApiOperation(value = "Create a new manager", response = List.class)
    @PostMapping("/manager")
    public Manager newManager(@RequestBody Manager newManager) {
        return repository.save(newManager);
    }

    // Single item
    @ApiOperation(value = "Get manager by Id", response = List.class)
    @GetMapping("/manager/{id}")
    public Manager getManagerByID(@PathVariable Long id) {

        return repository.findById(id).orElseThrow(() -> new ManagerNotFoundException(id));
    }

    @ApiOperation(value = "Delete a manager by its Id", response = List.class)
    @DeleteMapping("/Manager/{id}")
    public void deleteManager(@PathVariable Long id) {
        repository.deleteById(id);
    }


}
