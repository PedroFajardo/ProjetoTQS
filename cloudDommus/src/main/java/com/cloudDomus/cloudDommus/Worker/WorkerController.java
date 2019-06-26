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
    List<Worker> all() {
        return repository.findAll();
    }

    @ApiOperation(value = "Create a new worker", response = List.class)
    @PostMapping("/worker")
    Worker newWorker(@RequestBody Worker newWorker) {
        return repository.save(newWorker);
    }

    // Single item
    @ApiOperation(value = "Get worker by Id", response = List.class)
    @GetMapping("/worker/{id}")
    Worker getWorkerByID(@PathVariable Long id) {

        return repository.findById(id).orElseThrow(() -> new WorkerNotFoundException(id));
    }

   /* @ApiOperation(value = "Edit/Replace a worker by its Id", response = List.class)
    @PutMapping("/Worker/{id}")
    Worker replaceWorker(@RequestBody Worker newworker, @PathVariable Long id) {

        return repository.findById(id)
                .map(worker -> {
                    worker.setName(newworker.getName());
                    worker.setNumberWorkers(newworker.getNumberWorkers());
                    worker.setDescription(newworker.getDescription());
                    return repository.save(worker);
                })
                .orElseGet(() -> {
                    newworker.setId(id);
                    return repository.save(newworker;
                });
    }*/

    @ApiOperation(value = "Delete a worker by its Id", response = List.class)
    @DeleteMapping("/Worker/{id}")
    void deleteWorker(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
