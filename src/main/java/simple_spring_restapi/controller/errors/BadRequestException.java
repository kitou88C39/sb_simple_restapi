package simple_spring_restapi.controller.errors;

import org.springframework.http.HttpStatus;

public class BadRequestException extends HttpException {

    public BadRequestException() {

    }

    public BadRequestException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }

    public BadRequestException(Throwable cause) {
        super(cause, HttpStatus.BAD_REQUEST);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause, HttpStatus.BAD_REQUEST);
    }

    public BadRequestException(String message, Throwable cause, boolean enableSupprssion, boolean writableStackTrace) {
        super(message, cause, enableSupprssion, writableStackTrace, HttpStatus.BAD_REQUEST);
    }

}
