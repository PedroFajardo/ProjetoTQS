package com.cloudDomus.cloudDommus.User;

public class UserNotFoundException extends RuntimeException {

    UserNotFoundException(Long id) {
        super("Could not find work with id:  " + id);
    }

}