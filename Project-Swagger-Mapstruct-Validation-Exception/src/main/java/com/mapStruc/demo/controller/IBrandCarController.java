package com.mapStruc.demo.controller;

import com.mapStruc.demo.dto.BrandCarDto;
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

@Validated
@Tag(name = "BrandCar", description = "Operaciones permitidas sobre la entidad BrandCar")
@RequestMapping("/api")
public interface IBrandCarController {


    @Operation(summary = "Obtener la informacion de todas las BrandCars y Cars")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "BrandCar y Car",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BrandCarDto.class))})})
    @GetMapping(value ="/brandsAndCars", produces = MediaType.APPLICATION_JSON_VALUE)
    RestResponse<List<BrandCarDto>> listBrandsAndCars();


    @Operation(summary = "Obtener la informacion de todas las brandCars")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "BrandCar",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BrandCarDto.class))})})
    @GetMapping(value="/brands", produces = MediaType.APPLICATION_JSON_VALUE)
    RestResponse<List<BrandCarDto>> listBrandCars();


    @Operation(summary = "Obtener informacion de un brandCar por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "BrandCar obtenida",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BrandCarDto.class))}),
            @ApiResponse(responseCode = "404", description = "BrandCar no encontrada",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDto.class))}),
            @ApiResponse(responseCode = "400", description = "ID de BrandCar inválido",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDto.class))})
    })
    @GetMapping(value ="/brands/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    RestResponse<BrandCarDto> getBrandCarById(
            @Parameter(description = "El ID del BrandCar a obtener", required = true)
            @PathVariable @Positive(message = "el ID solo acepta numeros positivos")
            Long id);


    @Operation(summary = "Crear una nueva BrandCar")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "BrandCar creado",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BrandCarDto.class))}),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDto.class))}),
            @ApiResponse(responseCode = "404", description = "BrandCar no encontrada",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDto.class))})
    })
    @PostMapping(value="/brands", consumes = MediaType.APPLICATION_JSON_VALUE)
    RestResponse<BrandCarDto> createBrand(
            @Parameter(description = "Created BrandCar object", required = true)
            @RequestBody @Valid BrandCarDto brandCarDto);


    @Operation(summary = "Actualizar BrandCar")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "BrandCar actualizada",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BrandCarDto.class))}),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDto.class))}),
            @ApiResponse(responseCode = "404", description = "BrandCar no encontrada",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDto.class))})
    })
    @PutMapping(value="/updateBrand/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    RestResponse<BrandCarDto> updatedBrandCar(
            @Parameter(description = "El ID de la BrandCar a actualizar", required = true)
            @PathVariable @Positive(message = "el ID solo acepta numeros positivos")
            Long id,
            @Parameter(description = "The brandCar body.")
            @RequestBody @Valid BrandCarDto brandCarDto);


    @Operation(summary = "Eliminar BrandCar por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "BrandCar eliminada",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BrandCarDto.class))}),
            @ApiResponse(responseCode = "400", description = "Parámetro no válido o faltante",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDto.class))}),
            @ApiResponse(responseCode = "404", description = "BrandCar no encontrada",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDto.class))}),
            @ApiResponse(responseCode = "500", description = "Error interno en el servidor",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDto.class))})
    })
    @DeleteMapping("/deleteBrand/{id}")
    RestResponse<String> deleteBrandCar(
            @Parameter(description = "El ID de BrandCar a eliminar", required = true)
            @PathVariable @Positive(message = "el ID solo acepta numeros positivos")
            @Min(value = 1, message = "el ID mínimo permitido es 1")
            Long id);
}
