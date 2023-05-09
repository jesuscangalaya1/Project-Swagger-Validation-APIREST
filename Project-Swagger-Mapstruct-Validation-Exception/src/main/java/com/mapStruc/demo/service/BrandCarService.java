package com.mapStruc.demo.service;

import com.mapStruc.demo.dto.BrandCarDto;
import com.mapStruc.demo.dto.CarDto;
import com.mapStruc.demo.entity.BrandCarEntity;
import com.mapStruc.demo.exception.modelException.BusinessException;
import com.mapStruc.demo.exception.modelException.ResourceNotFoundException;
import com.mapStruc.demo.mapper.BrandCarMapper;
import com.mapStruc.demo.repository.BrandCarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class BrandCarService {

    private final BrandCarRepository brandCarRepository;
    private final BrandCarMapper brandCarMapper;

    public List<BrandCarDto> listBrandCars() {
        List<BrandCarEntity> brandCarEntityList = brandCarRepository.findAll();
        return brandCarMapper.brandCarListToBrandCarDtoList(brandCarEntityList);
    }

    public List<BrandCarDto> listBrandsAndCars() {
        List<BrandCarEntity> brandCarEntityList = brandCarRepository.findAll();
        return brandCarEntityList.stream()
                .map(brandCar -> {
                    BrandCarDto brandCarDto = brandCarMapper.brandCarToBrandCarDto(brandCar);
                    List<CarDto> carDtoList = brandCarMapper.carsToCarDtos(brandCar.getCars());
                    brandCarDto.setCars(carDtoList);
                    return brandCarDto;
                })
                .collect(Collectors.toList());
    }

    public BrandCarDto getBrandCarById(Long id) {
        BrandCarEntity brandCarEntity = brandCarRepository.findById(id)
                .orElseThrow(() -> new BusinessException("P-400", HttpStatus.BAD_REQUEST, "El Id del BrandCar no existe "+ id));
        return brandCarMapper.brandCarToBrandCarDto(brandCarEntity);
    }

    public BrandCarDto createBrandCar(BrandCarDto brandCarDto) {
        BrandCarEntity brandCarEntity = brandCarMapper.brandCarDtoToBrandCar(brandCarDto);
        BrandCarEntity savedBrandCarEntity = brandCarRepository.save(brandCarEntity);
        return brandCarMapper.brandCarToBrandCarDto(savedBrandCarEntity);
    }

    public BrandCarDto updateBrandCar(Long id, BrandCarDto brandCarDto) {
        BrandCarEntity brandCarEntity = brandCarRepository.findById(id)
                .orElseThrow(() -> new BusinessException("P-400", HttpStatus.BAD_REQUEST, "El Id del BrandCar no existe "+ id));
        brandCarMapper.updateBrandCarFromDto(brandCarDto, brandCarEntity);
        brandCarEntity = brandCarRepository.save(brandCarEntity);
        return brandCarMapper.brandCarToBrandCarDto(brandCarEntity);
    }

    public void deleteBrandCar(Long id) {
        if (!brandCarRepository.existsById(id)) {
            throw new BusinessException("P-400", HttpStatus.BAD_REQUEST, "El Id del BrandCar no existe");
        }
        brandCarRepository.deleteById(id);
    }
}
