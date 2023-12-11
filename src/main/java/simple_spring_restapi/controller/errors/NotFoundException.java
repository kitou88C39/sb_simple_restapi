package simple_spring_restapi.controller.errors;

import org.springframework.http.HttpStatus;

public class NotFoundException extends HttpException {

    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }

    public NotFoundException(Throwable cause) {
        super(cause, HttpStatus.BAD_REQUEST);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause, HttpStatus.BAD_REQUEST);
    }

    public NotFoundException(String message, Throwable cause, boolean enableSupprssion, boolean writableStackTrace) {
        super(message, cause, enableSupprssion, writableStackTrace, HttpStatus.BAD_REQUEST);
    }
}
