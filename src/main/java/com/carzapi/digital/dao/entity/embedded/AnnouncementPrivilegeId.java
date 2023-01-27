package com.carzapi.digital.dao.entity.embedded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementPrivilegeId implements Serializable {
    @Column(name = "announcement_id")
    private Long announcementId;
    @Column(name = "privilege_id")
    private Long privilegeId;

}
