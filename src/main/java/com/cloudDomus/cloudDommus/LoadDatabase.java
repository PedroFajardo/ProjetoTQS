package com.cloudDomus.cloudDommus;


import com.cloudDomus.cloudDommus.Service.Service;
import com.cloudDomus.cloudDommus.Service.ServiceRepository;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    /*private final Logger log =  LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ServiceRepository repository) {
        return args -> {
            log.info("Preloading {}", repository.save(new Service("House Cleaning", "The worker will clean you house.")));
            log.info("Preloading {}",repository.save(new Service("Clothes Washing and Ironing", "The worker will wash your clothes and then iron it.")));
            log.info("Preloading {}",repository.save(new Service("Babysitter", "The worker will babysit your children..")));
            log.info("Preloading {}",repository.save(new Service("Cooker", "The worker will cook food for your meals.")));
        };
    }*/
}