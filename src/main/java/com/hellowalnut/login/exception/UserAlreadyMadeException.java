package com.hellowalnut.login.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserAlreadyMadeException extends Exception { 
    public UserAlreadyMadeException(String errorMessage) {
        super(errorMessage);
    }
}
