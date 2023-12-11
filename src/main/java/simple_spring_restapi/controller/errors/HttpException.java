package simple_spring_restapi.controller.errors;

import org.springframework.http.HttpStatus;

public class HttpException extends RuntimeException {
    private HttpStatus httpStatus;

    public HttpException（）
    {
    }

    public HttpException(String message,HttpStatus httpStatus) {
        this.HttpStatus httpStatus;
        super(message);
    }

    public HttpException (Throwable case,HttpStatus httpStatus) {
        this.HttpStatus httpStatus;
        super(case);
    }

    public HttpException (String message,Throwable case,HttpStatus httpStatus) {
        this.HttpStatus httpStatus;
        super(message,case);
    }

    public HttpException (String message,Throwable case,boolean enableSupprssion, boolean writableStackTrace) {
        super(message,case,enableSupprssion,writableStackTrace);
    }
}
