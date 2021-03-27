package com.techmojo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
/**
 * GlobalExceptionHandler
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiError> handleException(HttpServletRequest request){
        System.out.println("inside ExceptionHandler");
        ApiError apiError = new ApiError(HttpStatus.UNAUTHORIZED);
        apiError.setMessage("Hourly Limit Exceeded");
        apiError.setPath(apiError.getPath());
        apiError.setDebugMessage("Try After Some time");
        return new ResponseEntity<ApiError>(apiError, HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);

    }
}
