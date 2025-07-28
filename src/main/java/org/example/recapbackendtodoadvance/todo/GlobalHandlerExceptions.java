package org.example.recapbackendtodoadvance.todo;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.time.ZonedDateTime;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalHandlerExceptions {

    @ExceptionHandler(ResponseStatusException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorMessage handleResponseStatusException(ResponseStatusException e) {
        return new ErrorMessage(ZonedDateTime.now(), e.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorMessage handleIllegalArgumentException(IllegalArgumentException e) {
        return new ErrorMessage(ZonedDateTime.now(), e.getMessage());
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ErrorMessage handleNoSuchElementException(NoSuchElementException e) {
        return new ErrorMessage(ZonedDateTime.now(), e.getMessage());
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorMessage handleNullPointerException(NullPointerException e) {
        return new ErrorMessage(ZonedDateTime.now(), e.getMessage());
    }

}
