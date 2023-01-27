package com.carzapi.digital.dao.repo;

import com.carzapi.digital.dao.entity.PrivilegeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepo extends JpaRepository<PrivilegeEntity, Long> {
}
