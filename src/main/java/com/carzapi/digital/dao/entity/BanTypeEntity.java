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
@Table(name="ban_types")
public class BanTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ban_type_name;

    @OneToMany(mappedBy = "banTypeEntity")
    private List<AnnouncementEntity> announcementEntityList_ban;

}
