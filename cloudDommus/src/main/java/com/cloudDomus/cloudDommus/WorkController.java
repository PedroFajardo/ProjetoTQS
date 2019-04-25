package com.cloudDomus.cloudDommus;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkController {

    private final WorkerRepository repository;

    WorkController(WorkerRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/works")
    List<Works> all() {
        return repository.findAll();
    }

    @PostMapping("/works")
    Works newWork(@RequestBody Works newWork) {
        return repository.save(newWork);
    }

    // Single item

    @GetMapping("/works/{id}")
    Works one(@PathVariable Long id) {

        return repository.findById(id).orElseThrow(() -> new WorksNotFoundException(id));
    }

    @PutMapping("/works/{id}")
    Works replaceWorks(@RequestBody Works newWork, @PathVariable Long id) {

        return repository.findById(id)
                .map(work -> {
                    work.setName(newWork.getName());
                    work.setNumberWorkers(newWork.getNumberWorkers());
                    work.setDescription(newWork.getDescription());
                    return repository.save(work);
                })
                .orElseGet(() -> {
                    newWork.setId(id);
                    return repository.save(newWork);
                });
    }

    @DeleteMapping("/works/{id}")
    void deleteWorks(@PathVariable Long id) {
        repository.deleteById(id);
    }

}

