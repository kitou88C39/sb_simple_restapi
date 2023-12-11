package simple_spring_restapi.controller.errors;

import org.springframework.http.HttpStatus;

public class HttpException extends RuntimeException {
    private HttpStatus httpStatus;

    public HttpException（）
    {
    }

    public HttpException(String message) {
        super(message);
    }

    public HttpException (Throwable case) {
        super(case);
    }

}
