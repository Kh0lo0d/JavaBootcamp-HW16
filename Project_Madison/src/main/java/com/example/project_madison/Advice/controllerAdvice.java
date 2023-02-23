package com.example.project_madison.Advice;

import com.example.project_madison.Exception.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
@RestControllerAdvice
public class controllerAdvice {



    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity ApiException(ApiException e)
    {
        String message=e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

    @ExceptionHandler(value= MethodArgumentNotValidException.class)
    public ResponseEntity MethodArgumentNotValidException(MethodArgumentNotValidException e)
    {
        String message =e.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(message);

    }

    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ApiException> SQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e){
        String msg=e.getMessage();
        return ResponseEntity.status(400).body(new ApiException(msg));
    }


}

