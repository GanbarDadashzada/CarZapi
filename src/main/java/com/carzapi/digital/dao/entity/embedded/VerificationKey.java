package com.carzapi.digital.dao.entity.embedded;

import com.carzapi.digital.model.enums.VerificationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class VerificationKey implements Serializable {
    @Column(name = "email")
    private String email;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private VerificationType type;

}
