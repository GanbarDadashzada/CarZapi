package com.carzapi.digital.dao.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fuels")
public class FuelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fuelName;
    @OneToMany(mappedBy = "fuelEntity")
    private List<AnnouncementEntity> announcementEntityList_fuel;
}
