package com.cloudDomus.cloudDommus.Manager;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

    Manager findByEmail(String email);

}
