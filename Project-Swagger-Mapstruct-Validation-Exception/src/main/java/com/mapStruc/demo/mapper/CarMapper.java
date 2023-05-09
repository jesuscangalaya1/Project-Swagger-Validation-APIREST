package com.mapStruc.demo.mapper;

import com.mapStruc.demo.dto.CarDto;
import com.mapStruc.demo.entity.CarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface CarMapper {

    @Mapping(source = "brandCar.id", target = "brandCarId")
    CarDto carToCarDto(CarEntity carEntity);

    @Mapping(source = "brandCarId", target = "brandCar.id")
    CarEntity carDtoToCar(CarDto carDto);




    void updateCarFromDto(CarDto carDto, @MappingTarget CarEntity carEntity);


    List<CarDto> carsToCarDtos(List<CarEntity> cars2List);

}
