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
    private GearBox gearBox;
    private Fuel fuel;
    private Integer year;
    private String model;
    private String brand;
    private String colour;
    private String city;
    private String banType;
    private List<String> conditions;
    private List<String> equipments;
}
