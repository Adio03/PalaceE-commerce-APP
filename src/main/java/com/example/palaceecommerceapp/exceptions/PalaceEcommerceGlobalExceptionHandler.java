package com.example.palaceecommerceapp.exceptions;

import com.example.palaceecommerceapp.exceptions.MerchantFoundException;
import com.example.palaceecommerceapp.exceptions.StoreAlreadyExistException;
import com.example.palaceecommerceapp.exceptions.StoreNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class PalaceEcommerceGlobalExceptionHandler {
    @ExceptionHandler(StoreAlreadyExistException.class)
    public ResponseEntity<Object> handleStoreAlreadyExistsException(StoreAlreadyExistException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MerchantFoundException.class)
    public ResponseEntity<Object> handleMerchantAlreadyExistException(MerchantFoundException exception) {
        Map<String, Object> messageBody = new LinkedHashMap<>();
        messageBody.put("message", exception.getMessage());

        return new ResponseEntity<>(messageBody, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StoreNotFoundException.class)
    public ResponseEntity<Object> handleStoreNotFoundException(StoreNotFoundException exception) {
        Map<String, Object> messageBody = new LinkedHashMap<>();
        messageBody.put("Message", exception.getMessage());
        return new ResponseEntity<>(messageBody, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleInputArgumentException(MethodArgumentNotValidException exception) {
        Map<String, Object> errorMap = new HashMap<>();
        exception.getBindingResult().getFieldErrors().
                forEach(error -> {
                    errorMap.put(error.getField(), error.getDefaultMessage());
                });
        return new ResponseEntity<>(errorMap,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MerchantNotFoundException.class)
    public ResponseEntity<Object> handleMerchantNotFoundException(MerchantNotFoundException exception){
        Map<String,Object> messageBody = new HashMap<>();
        messageBody.put("Message",exception.getMessage());

        return new ResponseEntity<>(messageBody,HttpStatus.NOT_FOUND);
    }
}

