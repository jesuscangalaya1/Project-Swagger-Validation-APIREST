package com.mapStruc.demo.mapper;

import com.mapStruc.demo.dto.BrandCarDto;
import com.mapStruc.demo.dto.CarDto;
import com.mapStruc.demo.entity.BrandCarEntity;
import com.mapStruc.demo.entity.CarEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-08T18:43:13-0600",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class BrandCarMapperImpl implements BrandCarMapper {

    @Autowired
    private CarMapper carMapper;

    @Override
    public BrandCarDto brandCarToBrandCarDto(BrandCarEntity brandCarEntity) {
        if ( brandCarEntity == null ) {
            return null;
        }

        BrandCarDto brandCarDto = new BrandCarDto();

        brandCarDto.setId( brandCarEntity.getId() );
        brandCarDto.setDescription( brandCarEntity.getDescription() );

        return brandCarDto;
    }

    @Override
    public BrandCarEntity brandCarDtoToBrandCar(BrandCarDto brandCarDto) {
        if ( brandCarDto == null ) {
            return null;
        }

        BrandCarEntity brandCarEntity = new BrandCarEntity();

        brandCarEntity.setId( brandCarDto.getId() );
        brandCarEntity.setDescription( brandCarDto.getDescription() );

        return brandCarEntity;
    }

    @Override
    public CarDto carToCarDtoWithBrandCarId(CarEntity carEntity) {
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
    public List<CarDto> carsToCarDtos(List<CarEntity> carEntities) {
        if ( carEntities == null ) {
            return null;
        }

        List<CarDto> list = new ArrayList<CarDto>( carEntities.size() );
        for ( CarEntity carEntity : carEntities ) {
            list.add( carToCarDtoWithBrandCarId( carEntity ) );
        }

        return list;
    }

    @Override
    public void updateBrandCarFromDto(BrandCarDto brandCarDto, BrandCarEntity brandCarEntity) {
        if ( brandCarDto == null ) {
            return;
        }

        brandCarEntity.setId( brandCarDto.getId() );
        brandCarEntity.setDescription( brandCarDto.getDescription() );
        if ( brandCarEntity.getCars() != null ) {
            List<CarEntity> list = carDtoListToCarEntityList( brandCarDto.getCars() );
            if ( list != null ) {
                brandCarEntity.getCars().clear();
                brandCarEntity.getCars().addAll( list );
            }
            else {
                brandCarEntity.setCars( null );
            }
        }
        else {
            List<CarEntity> list = carDtoListToCarEntityList( brandCarDto.getCars() );
            if ( list != null ) {
                brandCarEntity.setCars( list );
            }
        }
    }

    @Override
    public List<BrandCarDto> brandCarListToBrandCarDtoList(List<BrandCarEntity> brandCarEntityList) {
        if ( brandCarEntityList == null ) {
            return null;
        }

        List<BrandCarDto> list = new ArrayList<BrandCarDto>( brandCarEntityList.size() );
        for ( BrandCarEntity brandCarEntity : brandCarEntityList ) {
            list.add( brandCarToBrandCarDto( brandCarEntity ) );
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

    protected List<CarEntity> carDtoListToCarEntityList(List<CarDto> list) {
        if ( list == null ) {
            return null;
        }

        List<CarEntity> list1 = new ArrayList<CarEntity>( list.size() );
        for ( CarDto carDto : list ) {
            list1.add( carMapper.carDtoToCar( carDto ) );
        }

        return list1;
    }
}
