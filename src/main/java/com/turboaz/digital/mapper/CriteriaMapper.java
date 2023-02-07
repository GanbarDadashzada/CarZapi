package com.turboaz.digital.mapper;

import com.turboaz.digital.dao.entity.AnnouncementEntity;
import com.turboaz.digital.mapper.qualifier.MainQualifierImpl;
import com.turboaz.digital.mapper.qualifier.annotation.PrivilegeMappingQualifier;
import com.turboaz.digital.model.dto.LightAnnouncementDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.stream.Collectors;

@Mapper(imports = Collectors.class,
        uses = MainQualifierImpl.class)
public interface CriteriaMapper {
    CriteriaMapper INSTANCE = Mappers.getMapper(CriteriaMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "modelName", source = "modelEntity.modelName")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "ccy", source = "ccy")
    @Mapping(target = "motorSize", source = "motorSize")
    @Mapping(target = "distanceType", source = "distanceType")
    @Mapping(target = "distanceUnit", source = "distanceUnit")
    @Mapping(target = "year", source = "year")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "privileges", source = "announcementEntity",
            qualifiedBy = PrivilegeMappingQualifier.class)
    LightAnnouncementDto announcementToLightDto(AnnouncementEntity announcementEntity);

}
