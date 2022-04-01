package com.simbirsoft.paymentservice.exceptions;

import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

public class EntityUniqueException extends RuntimeException{

    HttpStatus httpStatus;
    List<String> errors;
    Object data;

    public EntityUniqueException(String message) {
        this(HttpStatus.UNPROCESSABLE_ENTITY, message);
    }

    public EntityUniqueException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public EntityUniqueException(HttpStatus httpStatus, String message) {
        this(httpStatus, message, Collections.singletonList(message), null);
    }

    public EntityUniqueException(HttpStatus httpStatus, String message, Object data) {
        this(httpStatus, message, Collections.singletonList(message), data);
    }

    public EntityUniqueException(HttpStatus httpStatus, String message, List<String> errors) {
        this(httpStatus, message, errors, null);
    }

    public EntityUniqueException(HttpStatus httpStatus, String message, List<String> errors, Object data) {
        super(message);
        this.httpStatus = httpStatus;
        this.errors = errors;
        this.data = data;
    }
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public List<String> getErrors() {
        return errors;
    }

    public Object getData() {
        return data;
    }
}
