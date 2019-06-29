package com.cloudDomus.cloudDommus.Manager;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ManagerNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ManagerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String managersNotFoundHandler(ManagerNotFoundException ex) {
        return ex.getMessage();
    }

}
