package ApiRestFinalProject.DentalClinic;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice

public class GlobalExceptionHandler extends Throwable {

    private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class);
@ExceptionHandler(Exception.class)
    public ResponseEntity<?> allErrors(Exception e) {

    logger.error(e.getMessage());
        return new ResponseEntity<>("Error: " + e.getCause(), HttpStatus.BAD_REQUEST);

    }


}
