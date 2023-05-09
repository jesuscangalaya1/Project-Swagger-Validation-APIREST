package com.mapStruc.demo.repository;

import com.mapStruc.demo.entity.BrandCarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandCarRepository extends JpaRepository<BrandCarEntity,Long> {
}
