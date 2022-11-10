package com.halleluhya.halleluhya.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
   @ExceptionHandler(HalleluhyaNotFoundException.class)
   public ResponseEntity<ErrorObject> handlehalleluhyanotfoundexception(HalleluhyaNotFoundException h, WebRequest request){
       ErrorObject errorObject = new ErrorObject();
       errorObject.setStatusCode(HttpStatus.NOT_FOUND.value());
       errorObject.setMessage(h.getMessage());
       errorObject.setTimestamp(new Date());

       return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.NOT_FOUND);
   }
}
