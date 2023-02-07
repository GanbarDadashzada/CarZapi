package com.carzapi.digital.dao.repo;

import com.carzapi.digital.dao.entity.VerificationEntity;
import com.carzapi.digital.dao.entity.embedded.VerificationKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VerificationRepo extends JpaRepository<VerificationEntity, Long> {
    Optional<VerificationEntity> findByIdAndToken (VerificationKey verificationKey, String token);
}
