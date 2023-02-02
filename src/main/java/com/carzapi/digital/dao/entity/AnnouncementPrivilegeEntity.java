package com.carzapi.digital.dao.entity;

import com.carzapi.digital.dao.entity.embedded.AnnouncementPrivilegeId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "announcement_privilege")
public class AnnouncementPrivilegeEntity {
    @EmbeddedId
    private AnnouncementPrivilegeId id;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("announcementId")
    private AnnouncementEntity announcementEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("privilegeId")
    private PrivilegeEntity privilegeEntity;
    @Column(name = "expired_at")
    private LocalDateTime expiredAt;

}
