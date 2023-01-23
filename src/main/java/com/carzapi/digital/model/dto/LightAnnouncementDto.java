package com.carzapi.digital.model.dto;

import com.carzapi.digital.model.enums.Privilege;
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
    private Integer motorSize;
    private String distanceType;
    private Integer distanceUnit;
    private Integer year;
    private List<Privilege> privileges;
    private LocalDateTime createdAt;

}
