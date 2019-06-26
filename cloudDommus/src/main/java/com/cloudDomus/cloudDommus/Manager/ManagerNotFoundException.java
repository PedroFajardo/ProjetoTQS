package com.cloudDomus.cloudDommus.Manager;
class ManagerNotFoundException extends RuntimeException {

    ManagerNotFoundException(Long id) {
        super("Could not find work with id:  " + id);
    }

}