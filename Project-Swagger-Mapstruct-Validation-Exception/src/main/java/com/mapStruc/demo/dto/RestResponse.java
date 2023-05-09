package com.mapStruc.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Data
public class RestResponse<T> implements Serializable {

    private String status;

    private String code;

    private String message;

    private T data;

    public RestResponse(String status, String code, String message) {
    }
}
