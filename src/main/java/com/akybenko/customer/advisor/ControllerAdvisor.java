package com.akybenko.customer.advisor;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.akybenko.customer.advisor.error.ErrorResponse;
import com.akybenko.customer.advisor.error.InvalidRequestArgErrorResponse;
import com.akybenko.customer.advisor.error.MultiErrorResponse;
import com.akybenko.customer.advisor.error.SingleErrorResponse;
import com.akybenko.customer.exception.EntityNotFoundException;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFoundException(EntityNotFoundException e,
                                                                       HttpServletRequest request) {
        HttpStatus httpStatus = NOT_FOUND;
        SingleErrorResponse response = SingleErrorResponse.builder()
                .status(httpStatus.value())
                .error(httpStatus.getReasonPhrase())
                .message(e.getMessage())
                .path(request.getServletPath())
                .build();
        return new ResponseEntity<>(response, httpStatus);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException e,
                                                                      HttpServletRequest request) {
        List<InvalidRequestArgErrorResponse> errors = e.getBindingResult().getFieldErrors().stream()
                .map(error ->
                        InvalidRequestArgErrorResponse.builder()
                                .arg(error.getField())
                                .message(error.getDefaultMessage())
                                .build())
                .collect(toList());
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        MultiErrorResponse response = MultiErrorResponse.builder()
                .status(httpStatus.value())
                .error(httpStatus.getReasonPhrase())
                .errors(errors)
                .path(request.getServletPath())
                .build();
        return new ResponseEntity<>(response, httpStatus);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrityViolationException(DataIntegrityViolationException e,
                                                                               HttpServletRequest request) {
        HttpStatus httpStatus = BAD_REQUEST;
        SingleErrorResponse response = SingleErrorResponse.builder()
                .status(httpStatus.value())
                .error(httpStatus.getReasonPhrase())
                .message(e.getMessage())
                .path(request.getServletPath())
                .build();
        return new ResponseEntity<>(response, httpStatus);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<Void> handleEmptyResultDataAccessException() {
        return ResponseEntity.notFound().build();
    }
}
