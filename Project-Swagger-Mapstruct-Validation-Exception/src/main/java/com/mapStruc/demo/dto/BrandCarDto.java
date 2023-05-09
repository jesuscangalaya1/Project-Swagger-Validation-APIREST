package com.mapStruc.demo.dto;


import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BrandCarDto {

    @Hidden
    @Schema(
            description = "Id de la persona",
            example = "1"
    )
    private Long id;

    @Schema(
            description = "Descripcion del brandCar",
            example = "Esto es una descripcion"
    )
    @NotNull
    @NotBlank(message = "Name must not be blank")
    @Length(min = 5 , max = 512, message = "Name must have 5 - 512 characters")
    private String description;

    @Schema(description = "Lista de carros")
    @Hidden  // para ocultar el json en el método POST.
    private List<CarDto> cars = new ArrayList<>();
}