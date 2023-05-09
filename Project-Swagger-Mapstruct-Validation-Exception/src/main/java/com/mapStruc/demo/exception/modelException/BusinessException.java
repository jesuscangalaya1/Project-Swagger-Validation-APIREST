package com.mapStruc.demo.exception.modelException;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;


@Data
public class BusinessException extends RuntimeException{

    private String code;
    private HttpStatus status;

    public BusinessException(String code, HttpStatus status, String message) {
        super(message);
        this.code = code;
        this.status = status;
    }
}
