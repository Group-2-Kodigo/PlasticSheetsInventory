package com.inventory.Inventory.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ColorNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ColorNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> exceptionHandler(ColorNotFoundException exception){
        Map<String, String> errorMap=new HashMap<>();
                errorMap.put("", exception.getMessage());
        return errorMap;
    }
}
