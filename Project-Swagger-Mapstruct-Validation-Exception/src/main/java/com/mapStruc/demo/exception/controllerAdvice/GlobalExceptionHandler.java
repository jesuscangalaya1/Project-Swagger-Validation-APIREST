package com.mapStruc.demo.exception.controllerAdvice;

import com.mapStruc.demo.dto.ErrorDto;
import com.mapStruc.demo.exception.modelException.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler{

    // Manejo de excepciones para BusinessException personalizada
    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<ErrorDto> businessExceptionHandler(BusinessException ex) {
        ErrorDto error = ErrorDto.builder().date(LocalDateTime.now()).code(ex.getCode()).message(ex.getMessage()).build();
        return new ResponseEntity<>(error, ex.getStatus());
    }

    // Manejo de excepciones para ResourceNotFoundException
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDto> handleResourceNotFoundException(ResourceNotFoundException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorDto error = ErrorDto.builder()
                .date(LocalDateTime.now())
                .code("P-404")
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(error, status);
    }


    // Manejo de excepciones para NotImplementedException
    @ExceptionHandler(NotImplementedException.class)
    public ResponseEntity<ErrorDto> handleNotImplementedException(NotImplementedException ex) {
        HttpStatus status = HttpStatus.NOT_IMPLEMENTED;
        ErrorDto error = ErrorDto.builder()
                .date(LocalDateTime.now())
                .code("P-501")
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(error, status);
    }

    // Manejo de excepciones para MethodArgumentNotValidException (validación de argumentos)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorDto error = ErrorDto.builder()
                .date(LocalDateTime.now())
                .code("P-400")
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(error, status);
    }

    // Manejo de excepciones para HttpMediaTypeNotSupportedException
   @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<ErrorDto> handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorDto error = ErrorDto.builder()
                .date(LocalDateTime.now())
                .code("P-400")
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(error, status);
    }


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorDto> handleRuntimeException(RuntimeException ex) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorDto error = ErrorDto.builder()
                .date(LocalDateTime.now())
                .code("P-500")
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(error, status);
    }

    // Manejo de excepciones para InternalServerErrorException personalizada
    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<ErrorDto> handleInternalServerErrorException(InternalServerErrorException ex) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorDto error = ErrorDto.builder()
                .date(LocalDateTime.now())
                .code("P-500")
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(error, status);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorDto> handleNullPointerException(NullPointerException ex) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorDto error = ErrorDto.builder()
                .date(LocalDateTime.now())
                .code("P-500")
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(error, status);
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<ErrorDto> handleDuplicateKeyException(DuplicateKeyException ex) {
        HttpStatus status = HttpStatus.CONFLICT;
        ErrorDto error = ErrorDto.builder()
                .date(LocalDateTime.now())
                .code("P-409")
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(error, status);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErrorDto> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
        HttpStatus status = HttpStatus.METHOD_NOT_ALLOWED;
        ErrorDto error = ErrorDto.builder()
                .date(LocalDateTime.now())
                .code("P-405")
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(error, status);
    }

}
