package simple_spring_restapi.controller.errors;

import org.springframework.http.HttpStatus;

@Getter
public class HttpException extends RuntimeException {
    private HttpStatus httpStatus;

    public HttpException（）
    {
    }

    public HttpException(String message,HttpStatus httpStatus) {
        super(message);
        this.HttpStatus httpStatus;
    }

    public HttpException (Throwable case,HttpStatus httpStatus) {
        super(case);
        this.HttpStatus httpStatus;
    }

    public HttpException (String message,Throwable case,HttpStatus httpStatus) {
        super(message,case);
        this.HttpStatus httpStatus;
    }

    public HttpException (String message,Throwable case,boolean enableSupprssion,boolean writableStackTrace) {
        super(message,case,enableSupprssion,writableStackTrace);
    }
}
