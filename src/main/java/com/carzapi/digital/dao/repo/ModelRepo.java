package com.carzapi.digital.dao.repo;

import com.carzapi.digital.dao.entity.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ModelRepo extends JpaRepository<ModelEntity, Long> {
    @Query("from ModelEntity where brandEntity.id = :brandId")
    List<ModelEntity> findByBrandId(Long brandId);
}
