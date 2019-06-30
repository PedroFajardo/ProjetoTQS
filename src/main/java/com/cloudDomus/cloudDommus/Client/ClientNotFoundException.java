package com.cloudDomus.cloudDommus.Client;

class ClientNotFoundException extends RuntimeException {

    ClientNotFoundException(Long id) {
        super("Could not find client with id:  " + id);
    }

}