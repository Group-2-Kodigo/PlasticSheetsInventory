package com.inventory.Inventory.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class SizeNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(SizeNotFondException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> exceptionHandler(SizeNotFondException exception){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("Error Message: ", exception.getMessage());
        return  errorMap;
    }
}
