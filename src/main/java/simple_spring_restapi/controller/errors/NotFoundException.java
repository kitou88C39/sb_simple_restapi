package simple_spring_restapi.controller.errors;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String cause) {
        super(cause);
    }

}
