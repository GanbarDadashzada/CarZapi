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
@Table(name = "colours")
public class ColourEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String colourName;

    @OneToMany(mappedBy = "colourEntity")
    private List<AnnouncementEntity> announcementEntities;
}
