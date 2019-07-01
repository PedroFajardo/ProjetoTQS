package com.cloudDomus.cloudDommus.Service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Long> {

    Service getById(Long id);
    Service findByType(String type);
    List<Service> getByType(String type);
}

