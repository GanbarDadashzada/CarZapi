package com.carzapi.digital.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class LightAnnouncementDto {
    private Long id;
    private String modelName;
    private Double price;
    private String ccy;
    private Integer motorSize;
    private String distanceType;
    private Integer distanceUnit;
    private Integer year;
    private List<String> privileges;
    private LocalDateTime createdAt;

}
