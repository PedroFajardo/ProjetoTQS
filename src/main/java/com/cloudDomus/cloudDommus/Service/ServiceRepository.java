package com.cloudDomus.cloudDommus.Service;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {

    Service findByID(Long id);

}

