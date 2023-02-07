package com.turboaz.digital.dao.repo;

import com.turboaz.digital.dao.entity.PrivilegeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepo extends JpaRepository<PrivilegeEntity, Long> {
}
