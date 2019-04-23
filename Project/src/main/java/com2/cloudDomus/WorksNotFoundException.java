package com2.cloudDomus;

class WorksNotFoundException extends RuntimeException {

    WorksNotFoundException(Long id) {
        super("Could not find work with id:  " + id);
    }

}