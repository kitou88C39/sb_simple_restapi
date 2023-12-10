package simple_spring_restapi.controller.errors;

public class BadRequestException extends RuntimeException {

    public BadRequestException() {

    }

    public BadRequestException(String message) {
        super(message);
    }

}
