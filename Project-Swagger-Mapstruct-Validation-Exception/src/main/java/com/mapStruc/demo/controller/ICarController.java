package com.mapStruc.demo.controller;

import com.mapStruc.demo.dto.CarDto;
import com.mapStruc.demo.dto.ErrorDto;
import com.mapStruc.demo.dto.RestResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Optional;

@Validated
@Tag(name = "Car", description = "Operaciones permitidas sobre la entidad Car")
@RequestMapping("/api")
public interface ICarController {

    @Operation(summary = "Obtener la informacion de todas las Cars")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Car",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CarDto.class))})})
    @GetMapping(value="/cars", produces = MediaType.APPLICATION_JSON_VALUE)
    RestResponse<List<CarDto>> listCars();


    @Operation(summary = "Obtener informacion de un Car por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Car obtenida",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CarDto.class))}),
            @ApiResponse(responseCode = "404", description = "Car no encontrada",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDto.class))}),
            @ApiResponse(responseCode = "400", description = "ID de Car inválido",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDto.class))})
    })
    @GetMapping(value ="/cars/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    RestResponse<Optional<CarDto>> getCarById(
            @Parameter(description = "El ID del Car a obtener", required = true)
            @PathVariable @Positive(message = "el ID solo acepta numeros positivos")
            Long id);


    @Operation(summary = "Crear una nueva Car")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Car creado",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CarDto.class))}),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDto.class))}),
            @ApiResponse(responseCode = "404", description = "Car no encontrada",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDto.class))})
    })
    @PostMapping(value="/cars", consumes = MediaType.APPLICATION_JSON_VALUE)
    RestResponse<CarDto> createCar(
            @Parameter(description = "Created Car object", required = true)
            @RequestBody @Valid CarDto carDto);


    @Operation(summary = "Actualizar Car")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Car actualizada",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CarDto.class))}),
            @ApiResponse(responseCode = "400", description = "Parámetro no válido o faltante",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDto.class))}),
            @ApiResponse(responseCode = "404", description = "Car no encontrada",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDto.class))}),
            @ApiResponse(responseCode = "500", description = "Error interno en el servidor",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDto.class))})
    })
    @PutMapping(value="/updateCar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    RestResponse<CarDto> updatedCar(
            @Parameter(description = "El ID de la Car a actualizar", required = true)
            @PathVariable @Positive(message = "el ID solo acepta numeros positivos")
            Long id,
            @Parameter(description = "The Car body.")
            @RequestBody @Valid CarDto carDto);


    @Operation(summary = "Eliminar Car por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Car eliminada",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CarDto.class))}),
            @ApiResponse(responseCode = "400", description = "Parámetro no válido o faltante",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDto.class))}),
            @ApiResponse(responseCode = "404", description = "Car no encontrada",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDto.class))}),
            @ApiResponse(responseCode = "500", description = "Error interno en el servidor",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDto.class))})
    })
    @DeleteMapping("/deleteCar/{id}")
    RestResponse<String> deleteCar(
            @Parameter(description = "El ID de la Car a eliminar", required = true)
            @PathVariable @Positive(message = "el ID solo acepta numeros positivos")
            @Min(value = 1, message = "el ID mínimo permitido es 1")
            Long id);
}
