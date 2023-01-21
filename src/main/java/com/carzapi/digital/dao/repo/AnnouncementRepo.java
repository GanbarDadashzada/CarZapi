package com.carzapi.digital.dao.repo;

import com.carzapi.digital.dao.entity.AnnouncementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AnnouncementRepo extends JpaRepository<AnnouncementEntity, Long>,
        JpaSpecificationExecutor<AnnouncementEntity> {
}
