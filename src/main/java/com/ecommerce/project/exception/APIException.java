package com.ecommerce.project.exception;

public class APIException extends RuntimeException{

    public static final long serialVersionUID = 1l;


    public APIException(String message) {
        super(message);
    }

    public APIException() {

    }
}
