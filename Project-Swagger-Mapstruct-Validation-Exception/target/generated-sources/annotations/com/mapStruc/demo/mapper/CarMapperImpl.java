package com.mapStruc.demo.mapper;

import com.mapStruc.demo.dto.CarDto;
import com.mapStruc.demo.entity.BrandCarEntity;
import com.mapStruc.demo.entity.CarEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-08T18:43:13-0600",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class CarMapperImpl implements CarMapper {

    @Override
    public CarDto carToCarDto(CarEntity carEntity) {
        if ( carEntity == null ) {
            return null;
        }

        CarDto carDto = new CarDto();

        carDto.setBrandCarId( carEntityBrandCarId( carEntity ) );
        carDto.setId( carEntity.getId() );
        carDto.setName( carEntity.getName() );
        carDto.setMatricula( carEntity.getMatricula() );
        carDto.setPrecio( carEntity.getPrecio() );

        return carDto;
    }

    @Override
    public CarEntity carDtoToCar(CarDto carDto) {
        if ( carDto == null ) {
            return null;
        }

        CarEntity carEntity = new CarEntity();

        carEntity.setBrandCar( carDtoToBrandCarEntity( carDto ) );
        carEntity.setId( carDto.getId() );
        carEntity.setName( carDto.getName() );
        carEntity.setMatricula( carDto.getMatricula() );
        carEntity.setPrecio( carDto.getPrecio() );

        return carEntity;
    }

    @Override
    public void updateCarFromDto(CarDto carDto, CarEntity carEntity) {
        if ( carDto == null ) {
            return;
        }

        carEntity.setId( carDto.getId() );
        carEntity.setName( carDto.getName() );
        carEntity.setMatricula( carDto.getMatricula() );
        carEntity.setPrecio( carDto.getPrecio() );
    }

    @Override
    public List<CarDto> carsToCarDtos(List<CarEntity> cars2List) {
        if ( cars2List == null ) {
            return null;
        }

        List<CarDto> list = new ArrayList<CarDto>( cars2List.size() );
        for ( CarEntity carEntity : cars2List ) {
            list.add( carToCarDto( carEntity ) );
        }

        return list;
    }

    private Long carEntityBrandCarId(CarEntity carEntity) {
        if ( carEntity == null ) {
            return null;
        }
        BrandCarEntity brandCar = carEntity.getBrandCar();
        if ( brandCar == null ) {
            return null;
        }
        Long id = brandCar.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected BrandCarEntity carDtoToBrandCarEntity(CarDto carDto) {
        if ( carDto == null ) {
            return null;
        }

        BrandCarEntity brandCarEntity = new BrandCarEntity();

        brandCarEntity.setId( carDto.getBrandCarId() );

        return brandCarEntity;
    }
}
