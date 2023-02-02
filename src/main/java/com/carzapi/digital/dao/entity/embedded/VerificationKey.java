package com.carzapi.digital.dao.entity.embedded;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VerificationKey implements Serializable {
    @Column(name = "email")
    private String email;
    @Column(name = "type")
    private String type;
}
