package com.cloudDomus.cloudDommus.Service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ServiceNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ServiceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String servicesNotFoundHandler(ServiceNotFoundException ex) {
        return ex.getMessage();
    }

}
