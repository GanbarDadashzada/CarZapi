package com.carzapi.digital.dao.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "announcements")
public class AnnouncementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String distanceType;
    private Integer distanceUnit;
    private String ccy;
    private Double price; // buna baxarsan
    private String ownership;
    private Integer seatCount;
    private String conductorType;
    private Integer motorSize;
    private Integer motorPower;
    private String vinCode;
    private String description;
    private String username;
    private String email;
    private String number;

    @ManyToOne
    @JoinColumn(name = "model_id", referencedColumnName = "id", nullable = false)
    private ModelEntity modelEntity;

    @ManyToOne
    @JoinColumn(name = "ban_type_id", referencedColumnName = "id", nullable = false)
    private BanTypeEntity banTypeEntity;

    @ManyToOne
    @JoinColumn(name = "colour_id", referencedColumnName = "id", nullable = false)
    private ColourEntity colourEntity;

    @ManyToOne
    @JoinColumn(name = "fuel_id", referencedColumnName = "id", nullable = false)
    private FuelEntity fuelEntity;

    @ManyToOne
    @JoinColumn(name = "gearbox_id", referencedColumnName = "id", nullable = false)
    private GearboxEntity gearboxEntity;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false)
    private CityEntity cityEntity;

    @ManyToMany
    @JoinTable(name = "announcement_equipments",
            joinColumns = {
                    @JoinColumn(name = "announcement_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "equipment_id", referencedColumnName = "id")
            }
    )
    private List<EquipmentEntity> equipmentEntities;

    @ManyToMany
    @JoinTable(name = "announcement_condition", joinColumns = {
            @JoinColumn(name = "announcement_id", referencedColumnName = "id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "condition_id", referencedColumnName = "id")
    }
    )
    private List<ConditionEntity> conditionEntities;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updateAt;

}
