package com.carzapi.digital.dao.repo;

import com.carzapi.digital.dao.entity.VerificationEntity;
import com.carzapi.digital.dao.entity.embedded.VerificationKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationRepo extends JpaRepository<VerificationEntity, VerificationKey> {
}
