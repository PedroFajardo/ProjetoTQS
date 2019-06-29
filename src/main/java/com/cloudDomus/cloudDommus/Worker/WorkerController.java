package com.cloudDomus.cloudDommus.Worker;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workers")
@Api(value="CloudDomus Worker Management System")
public class WorkerController {

    @Autowired
    WorkerRepository repository;

    // Aggregate root
    @ApiOperation(value = "View a list of available Worker", response = List.class)
    @GetMapping("/worker")
    public List<Worker> all() {
        return repository.findAll();
    }

    @ApiOperation(value = "Create a new worker", response = List.class)
    @PostMapping("/worker")
    public Worker newWorker(@RequestBody Worker newWorker) {
        return repository.save(newWorker);
    }

    // Single item
    @ApiOperation(value = "Get worker by Id", response = List.class)
    @GetMapping("/worker/{id}")
    public Worker getWorkerByID(@PathVariable Long id) {

        return repository.findById(id).orElseThrow(() -> new WorkerNotFoundException(id));
    }

    @ApiOperation(value = "Delete a worker by its Id", response = List.class)
    @DeleteMapping("/Worker/{id}")
    public void deleteWorker(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
