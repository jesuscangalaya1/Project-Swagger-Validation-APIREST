package com.mapStruc.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class ErrorDto {

    private LocalDateTime date;
    private String code;
    private String message;
}
