package com.mapStruc.demo.service;

import com.mapStruc.demo.dto.CarDto;
import com.mapStruc.demo.entity.BrandCarEntity;
import com.mapStruc.demo.entity.CarEntity;
import com.mapStruc.demo.exception.modelException.BusinessException;
import com.mapStruc.demo.exception.modelException.ResourceNotFoundException;
import com.mapStruc.demo.mapper.CarMapper;
import com.mapStruc.demo.repository.BrandCarRepository;
import com.mapStruc.demo.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final BrandCarRepository brandCarRepository;
    private final CarMapper carMapper;


    public List<CarDto> listCars() {
        return carMapper.carsToCarDtos(carRepository.findAll());
    }

    public Optional<CarDto> getCarById(Long id) {
        return Optional.ofNullable(carRepository.findById(id)
                .map(carMapper::carToCarDto)
                .orElseThrow(() -> new BusinessException("P-400", HttpStatus.BAD_REQUEST, "El Id del Carro no existe " + id)));
    }

    public CarDto createCar(CarDto carDto) {
        BrandCarEntity brandCarEntity = brandCarRepository.findById(carDto.getBrandCarId())
                .orElseThrow(() -> new BusinessException("P-400", HttpStatus.BAD_REQUEST, "El Id del Carro no existe " + carDto.getBrandCarId()));
        CarEntity carEntity = carMapper.carDtoToCar(carDto);
        carEntity.setBrandCar(brandCarEntity);
        CarEntity savedCarEntity = carRepository.save(carEntity);
        return carMapper.carToCarDto(savedCarEntity);
    }

    public CarDto updateCar(Long id, CarDto carDto) {
        CarEntity carEntity = carRepository.findById(id)
                .orElseThrow(() -> new BusinessException("P-400", HttpStatus.BAD_REQUEST, "El Id del Carro no existe " + id));

        carMapper.updateCarFromDto(carDto, carEntity);

        carEntity = carRepository.save(carEntity);
        return carMapper.carToCarDto(carEntity);
    }

    public void deleteCar(Long id) {
        if (!carRepository.existsById(id)) {
            throw new BusinessException("P-400", HttpStatus.BAD_REQUEST, "El Id del Carro no existe");
        }
        carRepository.deleteById(id);
    }
}

