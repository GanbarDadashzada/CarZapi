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
public class AnnouncementCriteria {

    private Long brandId;
    private Long modelId;
    private Long cityId;
    private Double priceTo;
    private Double priceFrom;
    private Integer yearFrom;
    private Integer yearTo;
    private Integer motorSizeFrom;
    private Integer motorSizeTo;
    private Integer motorPowerFrom;
    private Integer motorPowerTo;
    private Integer distanceUnitFrom;
    private Integer distanceUnitTo;
    private String ccy;
    private Long banTypeId;
    private Long colourId;
    private Fuel fuel;
    private GearBox gearBox;
    private String conductorType;
    private String distanceType;
    private String ownership;
    private Integer seatCount;
    private List<Long> privilegeIds;
    private List<Long> conditionIds;
    private List<Long> equipmentIds;

}
