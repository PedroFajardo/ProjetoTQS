package CloudDomus;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class WorkNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(WorksNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String worksNotFoundHandler(WorksNotFoundException ex) {
        return ex.getMessage();
    }

}
