package com.cloudDomus.cloudDommus.Worker;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class WorkerNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(WorkerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String workersNotFoundHandler(WorkerNotFoundException ex) {
        return ex.getMessage();
    }

}
