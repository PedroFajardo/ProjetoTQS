package com.cloudDomus.cloudDommus.Service;

public class ServiceNotFoundException extends RuntimeException {

    ServiceNotFoundException(Long id) {
        super("Could not find work with id:  " + id);
    }

}