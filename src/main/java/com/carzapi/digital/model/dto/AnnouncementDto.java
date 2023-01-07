package com.carzapi.digital.model.dto;

import com.carzapi.digital.model.enums.Fuel;
import com.carzapi.digital.model.enums.GearBox;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementDto {
    private Long id;
    private String distanceType;
    private Integer distanceUnit;
    private String ccy;
    private Double price;
    private String ownership;
    private Integer seatCount;
    private String conductorType;
    private Integer motorSize;
    private Integer motorPower;
    private String vinCode;
    private String description;
    private String fullName;
    private String email;
    private Long modelId;
    private Long colourId;
    private Long cityId;
    private GearBox gearBox;
    private Long banTypeId;
    private Fuel fuel;
    private List<Long> conditionIds;
    private List<Long> equipmentIds;
}
