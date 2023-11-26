package com.dashdash.backend.application.exception;

import com.dashdash.backend.application.model.response.ApiResultResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ApiResultResponse handleResourceNotFoundException(ResourceNotFoundException exception) {

        return new ApiResultResponse(exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResultResponse handleGlobalException(Exception exception) {

        return new ApiResultResponse(exception.getMessage());
    }
}

