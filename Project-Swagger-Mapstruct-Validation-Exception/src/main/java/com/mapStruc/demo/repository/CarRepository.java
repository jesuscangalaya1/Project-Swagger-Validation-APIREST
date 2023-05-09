package com.mapStruc.demo.repository;

import com.mapStruc.demo.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarEntity,Long> {
}
