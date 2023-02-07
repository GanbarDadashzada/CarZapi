package com.turboaz.digital.dao.repo;

import com.turboaz.digital.dao.entity.VerificationEntity;
import com.turboaz.digital.dao.entity.embedded.VerificationKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VerificationRepo extends JpaRepository<VerificationEntity, Long> {
    Optional<VerificationEntity> findByIdAndToken (VerificationKey verificationKey, String token);
}
