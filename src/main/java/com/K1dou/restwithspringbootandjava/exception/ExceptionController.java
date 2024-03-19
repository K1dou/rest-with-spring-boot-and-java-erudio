package com.K1dou.restwithspringbootandjava.exception;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@ResponseStatus
public class ExceptionController {
//    @ExceptionHandler(RuntimeException.class)
//    private ResponseEntity<ExceptionResponseBody>exceptionAll(RuntimeException ex){
//        ExceptionResponseBody exceptionResponseBody = new ExceptionResponseBody(ex.getMessage(), new Date());
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponseBody);
//    }

    @ExceptionHandler(ResourceNotFoundException.class)
    private ResponseEntity<ExceptionResponseBody> handleNotFoundExceptions(ResourceNotFoundException ex) {
        ExceptionResponseBody exceptionResponseBody = new ExceptionResponseBody(ex.getMessage(), new Date(),HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponseBody);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<ExceptionResponseBean> handleNotFoundExceptions(MethodArgumentNotValidException ex) {
        List<String> e = ex.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
        ExceptionResponseBean exceptionResponseBody = new ExceptionResponseBean(e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponseBody);
    }
 @ExceptionHandler(InvalidJwtAuthenticationException.class)
    private ResponseEntity<ExceptionResponseBody> handleInvalidJwtAuthenticationException(InvalidJwtAuthenticationException ex) {
     ExceptionResponseBody exceptionResponseBody = new ExceptionResponseBody(ex.getMessage(), new Date(),HttpStatus.NOT_FOUND);

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(exceptionResponseBody);
    }


}
