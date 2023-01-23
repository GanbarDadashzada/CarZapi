package com.carzapi.digital.mapper;

import com.carzapi.digital.dao.entity.AnnouncementEntity;
import com.carzapi.digital.dao.entity.BanTypeEntity;
import com.carzapi.digital.dao.entity.CityEntity;
import com.carzapi.digital.dao.entity.ColourEntity;
import com.carzapi.digital.dao.entity.ConditionEntity;
import com.carzapi.digital.dao.entity.EquipmentEntity;
import com.carzapi.digital.dao.entity.ModelEntity;
import com.carzapi.digital.model.dto.AnnouncementDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(imports = Collectors.class)
public interface AnnouncementMapper {
    AnnouncementMapper INSTANCE = Mappers.getMapper(AnnouncementMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "distanceType", source = "announcementDto.distanceType")
    @Mapping(target = "distanceUnit", source = "announcementDto.distanceUnit")
    @Mapping(target = "ccy", source = "announcementDto.ccy")
    @Mapping(target = "price", source = "announcementDto.price")
    @Mapping(target = "year", source = "announcementDto.year")
    @Mapping(target = "ownership", source = "announcementDto.ownership")
    @Mapping(target = "seatCount", source = "announcementDto.seatCount")
    @Mapping(target = "conductorType", source = "announcementDto.conductorType")
    @Mapping(target = "motorSize", source = "announcementDto.motorSize")
    @Mapping(target = "motorPower", source = "announcementDto.motorPower")
    @Mapping(target = "vinCode", source = "announcementDto.vinCode")
    @Mapping(target = "description", source = "announcementDto.description")
    @Mapping(target = "fullName", source = "announcementDto.fullName")
    @Mapping(target = "email", source = "announcementDto.email")
    @Mapping(target = "modelEntity", source = "modelEntity")
    @Mapping(target = "banTypeEntity", source = "banTypeEntity")
    @Mapping(target = "colourEntity", source = "colourEntity")
    @Mapping(target = "cityEntity", source = "cityEntity")
    @Mapping(target = "equipmentEntities", source = "equipmentEntities")
    @Mapping(target = "conditionEntities", source = "conditionEntities")
    AnnouncementEntity buildAnnouncementEntity(
            AnnouncementDto announcementDto,
            ModelEntity modelEntity,
            BanTypeEntity banTypeEntity,
            ColourEntity colourEntity,
            CityEntity cityEntity,
            List<EquipmentEntity> equipmentEntities,
            List<ConditionEntity> conditionEntities
    );

    @InheritInverseConfiguration
    @Mapping(target = "modelId", source = "modelEntity.id")
    @Mapping(target = "banTypeId", source = "banTypeEntity.id")
    @Mapping(target = "cityId", source = "cityEntity.id")
    @Mapping(target = "colourId", source = "colourEntity.id")
    @Mapping(target = "equipmentIds",
            expression = "java(announcementEntity.getEquipmentEntities().stream().map(e -> e.getId()).collect(Collectors.toList()))")
    @Mapping(target = "conditionIds",
            expression = "java(announcementEntity.getConditionEntities().stream().map(c -> c.getId()).collect(Collectors.toList()))")
    AnnouncementDto announcementEntityToDto(AnnouncementEntity announcementEntity);

}
