package com.cloudDomus.cloudDommus.Worker;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

    Worker findByEmail(String email);

}
