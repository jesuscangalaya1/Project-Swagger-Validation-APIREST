package com.mapStruc.demo.controller.impl;

import com.mapStruc.demo.controller.IBrandCarController;
import com.mapStruc.demo.dto.BrandCarDto;
import com.mapStruc.demo.dto.RestResponse;
import com.mapStruc.demo.service.BrandCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BrandCarController implements IBrandCarController {

    private final BrandCarService brandCarService;

    @Override
    public RestResponse<List<BrandCarDto>> listBrandsAndCars() {
        return new RestResponse<>("SUCCESS",
                String.valueOf(HttpStatus.OK),
                "BRANDCAR AND CARS SUCCESSFULLY READED",
                brandCarService.listBrandsAndCars());
    }

    @Override
    public RestResponse<List<BrandCarDto>> listBrandCars() {
        return new RestResponse<>("SUCCESS",
                String.valueOf(HttpStatus.OK),
                "BRANDCARS SUCCESSFULLY READED",
                brandCarService.listBrandCars());
    }

    @Override
    public RestResponse<BrandCarDto> getBrandCarById(Long id) {
        return new RestResponse<>("SUCCESS",
                String.valueOf(HttpStatus.OK),
                "BRANDCAR ID: " +id+" SUCCESSFULLY READED",
                brandCarService.getBrandCarById(id));
    }

    @Override
    public RestResponse<BrandCarDto> createBrand(BrandCarDto brandCarDto) {
        return new RestResponse<>("SUCCESS",
                String.valueOf(HttpStatus.CREATED),
                "BRANDCAR SUCCESSFULLY CREATED",
                brandCarService.createBrandCar(brandCarDto));
    }

    @Override
    public RestResponse<BrandCarDto> updatedBrandCar(Long id, BrandCarDto brandCarDto) {
        return new RestResponse<>("SUCCESS",
                String.valueOf(HttpStatus.OK),
                "BRANDCAR ID: "+id+" SUCCESSFULLY UPDATED",
                brandCarService.updateBrandCar(id, brandCarDto));
    }

    @Override
    public RestResponse<String> deleteBrandCar(Long id) {
        brandCarService.deleteBrandCar(id);
        return new RestResponse<>("SUCCESS",
                String.valueOf(HttpStatus.OK),
                "BRANDCAR ID: " +id+" SUCCESSFULLY DELETED",
                ""); // Data null.
    }





/*    @GetMapping("/brandsAndCars")
    public List<BrandCarDto> getAllBrandsAndCars() {
        return brandCarService.findAllBrandsAndCars();
    }

    @GetMapping("/brands")
    public List<BrandCarDto> getAllBrands() {
        return brandCarService.findAll();
    }

    @GetMapping("/brands/{id}")
    public BrandCarDto getBrandById(@PathVariable Long id) {
        return brandCarService.findById(id);
    }

    @PostMapping("/brands")
    @ResponseStatus(HttpStatus.CREATED)
    public BrandCarDto createBrand(@RequestBody BrandCarDto brandCarDto) {
        return brandCarService.saveBrandCar(brandCarDto);
    }

    @PutMapping("/updateBrand/{id}")
    public ResponseEntity<BrandCarDto> updatedBrandCar(@PathVariable Long id, @RequestBody BrandCarDto brandCarDto){
        return new ResponseEntity<>(brandCarService.update(id, brandCarDto), HttpStatus.OK);
    }

    @DeleteMapping("/deleteBrand/{id}")
    public ResponseEntity<String> deleteBrandCar(@PathVariable Long id){
        brandCarService.deleteById(id);
        return new ResponseEntity<>("Eliminado exitosamente", HttpStatus.OK);
    }*/
}
