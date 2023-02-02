package com.carzapi.digital.model.dto;

import com.carzapi.digital.model.enums.VerificationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class VerificationDto {
    private String token;
    private String email;
    private VerificationType type;
}
