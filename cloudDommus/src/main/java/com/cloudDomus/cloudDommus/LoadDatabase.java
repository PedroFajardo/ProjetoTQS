package com.cloudDomus.cloudDommus;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    //private final Logger log =  LoggerFactory.getLogger(LoadDatabase.class);

    /*@Bean
    CommandLineRunner initDatabase(WorkerRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Works("A", 2, "a")));
            log.info("Preloading " + repository.save(new Works("B", 3, "b")));
        };
    }*/
}