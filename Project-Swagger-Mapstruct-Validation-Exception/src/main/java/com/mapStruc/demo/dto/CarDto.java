package com.mapStruc.demo.dto;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarDto {

    @Hidden
    private Long id;

    @Schema(
            description = "Nombre del Car",
            example = "Jesus"
    )
    @NotBlank(message = "Name must not be blank")
    @Length(min = 5 , max = 50, message = "Name must have 5 - 50 characters")
    private String name;

    @Schema(
            description = "Nombre de la Matricula",
            example = "ABC-123"
    )
    @NotBlank(message = "Matricula must not be blank")
    @Length(min = 5 , max = 50, message = "Matricula must have 5 - 512 characters")
    private String matricula;

    @Schema(
            description = "Precio",
            example = "2000"
    )
    @Min(value = 10 , message = "Car price must be greater than 9")
    @Max(value = 9999, message = "Car price must be less than 10000")
    private String precio;

    @Schema(
            description = "ID Brandcar",
            example = "1"
    )
    @NotBlank(message = "El ID no puede estar en blanco")
    @Positive(message = "El ID debe ser un número positivo mayor que cero")
    private Long brandCarId;

}
