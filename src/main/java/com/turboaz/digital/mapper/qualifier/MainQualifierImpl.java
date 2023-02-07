package com.turboaz.digital.mapper.qualifier;

import com.turboaz.digital.dao.entity.AnnouncementEntity;
import com.turboaz.digital.mapper.qualifier.annotation.MainQualifier;
import com.turboaz.digital.mapper.qualifier.annotation.PrivilegeMappingQualifier;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@MainQualifier
public class MainQualifierImpl {

    @PrivilegeMappingQualifier
    public List<String> privilegeMappingQualifier(AnnouncementEntity announcementEntity) {
        return announcementEntity.getAnnouncementPrivilegeEntities()
                .stream()
                .filter(a -> a.getExpiredAt().isAfter(LocalDateTime.now()))
                .map(p -> p.getPrivilegeEntity().getName())
                .collect(Collectors.toList());
    }
}
