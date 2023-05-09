package com.mapStruc.demo.exception.modelException;

import lombok.Data;

@Data
public class NotImplementedException extends RuntimeException {

    private String message;


    public NotImplementedException(String message) {
        super();
        this.message = message;
    }
}
