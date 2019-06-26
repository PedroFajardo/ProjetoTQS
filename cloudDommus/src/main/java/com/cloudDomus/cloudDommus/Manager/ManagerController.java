package com.cloudDomus.cloudDommus.Manager;

import com.cloudDomus.cloudDommus.Manager.Manager;
import com.cloudDomus.cloudDommus.Manager.ManagerNotFoundException;
import com.cloudDomus.cloudDommus.Manager.ManagerRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
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
    List<Manager> all() {
        return repository.findAll();
    }

    @ApiOperation(value = "Create a new manager", response = List.class)
    @PostMapping("/manager")
    Manager newManager(@RequestBody Manager newManager) {
        return repository.save(newManager);
    }

    // Single item
    @ApiOperation(value = "Get manager by Id", response = List.class)
    @GetMapping("/manager/{id}")
    Manager getManagerByID(@PathVariable Long id) {

        return repository.findById(id).orElseThrow(() -> new ManagerNotFoundException(id));
    }

   /* @ApiOperation(value = "Edit/Replace a manager by its Id", response = List.class)
    @PutMapping("/Manager/{id}")
    Manager replaceManager(@RequestBody Manager newmanager, @PathVariable Long id) {

        return repository.findById(id)
                .map(manager -> {
                    manager.setName(newmanager.getName());
                    manager.setNumberWorkers(newmanager.getNumberWorkers());
                    manager.setDescription(newmanager.getDescription());
                    return repository.save(manager);
                })
                .orElseGet(() -> {
                    newmanager.setId(id);
                    return repository.save(newmanager;
                });
    }*/

    @ApiOperation(value = "Delete a manager by its Id", response = List.class)
    @DeleteMapping("/Manager/{id}")
    void deleteManager(@PathVariable Long id) {
        repository.deleteById(id);
    }


}
