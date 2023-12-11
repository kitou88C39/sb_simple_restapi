package simple_spring_restapi.controller.errors;

public class BadRequestException extends RuntimeException {

    public BadRequestException() {

    }

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(Throwable cause) {
        super(cause);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadRequestException(String message, Throwable cause, boolean enableSupprssion, boolean writableStackTrace) {
        super(message, cause, enableSupprssion, writableStackTrace);
    }

}
