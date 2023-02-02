package com.carzapi.digital.dao.repo;

import com.carzapi.digital.dao.entity.AnnouncementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnnouncementRepo extends JpaRepository<AnnouncementEntity, Long>,
        JpaSpecificationExecutor<AnnouncementEntity> {
    @Query("select email from AnnouncementEntity where email = :email")
    String findByEmail (String email);
}
