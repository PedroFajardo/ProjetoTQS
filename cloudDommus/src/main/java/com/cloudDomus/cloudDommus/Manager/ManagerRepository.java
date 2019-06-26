package com.cloudDomus.cloudDommus.Manager;

import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

}
