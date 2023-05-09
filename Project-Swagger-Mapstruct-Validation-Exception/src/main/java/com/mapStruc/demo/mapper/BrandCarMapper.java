package com.mapStruc.demo.mapper;

import com.mapStruc.demo.dto.BrandCarDto;
import com.mapStruc.demo.dto.CarDto;
import com.mapStruc.demo.entity.BrandCarEntity;
import com.mapStruc.demo.entity.CarEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(uses = {CarMapper.class})
public interface BrandCarMapper {

    @Mapping(source = "cars", target = "cars", ignore = true)
    BrandCarDto brandCarToBrandCarDto(BrandCarEntity brandCarEntity);

    @InheritInverseConfiguration
    BrandCarEntity brandCarDtoToBrandCar(BrandCarDto brandCarDto);


    //Listar los brands y cars juntos.
    @Named("withBrandCarId")
    @Mapping(source = "brandCar.id", target = "brandCarId")
    CarDto carToCarDtoWithBrandCarId(CarEntity carEntity);

    @IterableMapping(qualifiedByName = "withBrandCarId")
    List<CarDto> carsToCarDtos(List<CarEntity> carEntities);


    void updateBrandCarFromDto(BrandCarDto brandCarDto, @MappingTarget BrandCarEntity brandCarEntity);



    // listar solo los brands
    List<BrandCarDto> brandCarListToBrandCarDtoList(List<BrandCarEntity> brandCarEntityList);


}



