package com.techmojo.exception;

import org.springframework.http.HttpStatus;

/**
 * Sample Error message class to bind the errors and sent it as json response
 */
public class ApiError {
    private HttpStatus status;

    private String message;

    private String debugMessage;

    private String path;

    public ApiError(HttpStatus status) {
      this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}