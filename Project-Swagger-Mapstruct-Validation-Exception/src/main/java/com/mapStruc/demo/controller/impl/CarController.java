package com.mapStruc.demo.controller.impl;

import com.mapStruc.demo.controller.ICarController;
import com.mapStruc.demo.dto.CarDto;
import com.mapStruc.demo.dto.RestResponse;
import com.mapStruc.demo.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CarController implements ICarController {

    private final CarService carService;

    @Override
    public RestResponse<List<CarDto>> listCars() {
        return new RestResponse<>("SUCCESS",
                String.valueOf(HttpStatus.OK),
                "CARS SUCCESSFULLY READED",
                carService.listCars());
    }

    @Override
    public RestResponse<Optional<CarDto>> getCarById(Long id) {
        return new RestResponse<>("SUCCESS",
                String.valueOf(HttpStatus.OK),
                "CAR ID: " + id + " SUCCESSFULLY READED",
                carService.getCarById(id));
    }

    @Override
    public RestResponse<CarDto> createCar(CarDto carDto) {
        return new RestResponse<>("SUCCESS",
                String.valueOf(HttpStatus.CREATED),
                "CAR SUCCESSFULLY CREATED",
                carService.createCar(carDto));
    }

    @Override
    public RestResponse<CarDto> updatedCar(Long id, CarDto carDto) {
        return new RestResponse<>("SUCCESS",
                String.valueOf(HttpStatus.OK),
                "CAR ID: " + id + " SUCCESSFULLY UPDATED",
                carService.updateCar(id, carDto));
    }

    @Override
    public RestResponse<String> deleteCar(Long id) {
        carService.deleteCar(id);
        return new RestResponse<>("SUCCESS",
                String.valueOf(HttpStatus.OK),
                "CAR ID: " + id + " SUCCESSFULLY DELETED",
                ""); // Data null.
    }
}

