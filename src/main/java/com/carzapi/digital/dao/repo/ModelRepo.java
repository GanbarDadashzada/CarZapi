package com.carzapi.digital.dao.repo;

import com.carzapi.digital.dao.entity.ModelEntity;
import com.carzapi.digital.model.dto.DictionaryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModelRepo extends JpaRepository<ModelEntity,Long> {
    @Query(nativeQuery = true)
    List<ModelEntity> findByBrandId (@Param("brand_id") Long id);
}
