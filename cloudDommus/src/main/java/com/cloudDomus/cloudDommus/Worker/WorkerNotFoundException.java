package com.cloudDomus.cloudDommus.Worker;

public class WorkerNotFoundException extends RuntimeException {

    WorkerNotFoundException(Long id) {
        super("Could not find work with id:  " + id);
    }

}
