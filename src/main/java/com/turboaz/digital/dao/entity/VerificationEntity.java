package com.turboaz.digital.dao.entity;

import com.turboaz.digital.dao.entity.embedded.VerificationKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "verifications")
@EqualsAndHashCode(of = "id")
public class VerificationEntity {
    @EmbeddedId
    private VerificationKey id;
    private String token;

}
