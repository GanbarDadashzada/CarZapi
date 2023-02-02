package com.carzapi.digital.mapper;

import com.carzapi.digital.dao.entity.AnnouncementEntity;
import com.carzapi.digital.dao.entity.AnnouncementPrivilegeEntity;
import com.carzapi.digital.dao.entity.BanTypeEntity;
import com.carzapi.digital.dao.entity.CityEntity;
import com.carzapi.digital.dao.entity.ColourEntity;
import com.carzapi.digital.dao.entity.ConditionEntity;
import com.carzapi.digital.dao.entity.EquipmentEntity;
import com.carzapi.digital.dao.entity.ModelEntity;
import com.carzapi.digital.dao.entity.PrivilegeEntity;
import com.carzapi.digital.dao.entity.embedded.AnnouncementPrivilegeId;
import com.carzapi.digital.model.dto.AnnouncementDto;
import com.carzapi.digital.model.dto.AnnouncementRequest;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(imports = {Collectors.class, AnnouncementPrivilegeId.class})
public interface AnnouncementMapper {
    AnnouncementMapper INSTANCE = Mappers.getMapper(AnnouncementMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "distanceType", source = "announcementRequest.distanceType")
    @Mapping(target = "distanceUnit", source = "announcementRequest.distanceUnit")
    @Mapping(target = "ccy", source = "announcementRequest.ccy")
    @Mapping(target = "price", source = "announcementRequest.price")
    @Mapping(target = "year", source = "announcementRequest.year")
    @Mapping(target = "ownership", source = "announcementRequest.ownership")
    @Mapping(target = "seatCount", source = "announcementRequest.seatCount")
    @Mapping(target = "conductorType", source = "announcementRequest.conductorType")
    @Mapping(target = "motorSize", source = "announcementRequest.motorSize")
    @Mapping(target = "motorPower", source = "announcementRequest.motorPower")
    @Mapping(target = "vinCode", source = "announcementRequest.vinCode")
    @Mapping(target = "description", source = "announcementRequest.description")
    @Mapping(target = "fullName", source = "announcementRequest.fullName")
    @Mapping(target = "email", source = "announcementRequest.email")
    @Mapping(target = "modelEntity", source = "modelEntity")
    @Mapping(target = "banTypeEntity", source = "banTypeEntity")
    @Mapping(target = "colourEntity", source = "colourEntity")
    @Mapping(target = "cityEntity", source = "cityEntity")
    @Mapping(target = "equipmentEntities", source = "equipmentEntities")
    @Mapping(target = "conditionEntities", source = "conditionEntities")
    AnnouncementEntity buildAnnouncementEntity(
            AnnouncementRequest announcementRequest,
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
    AnnouncementRequest announcementEntityToDto(AnnouncementEntity announcementEntity);

    @Mapping(target = "id",
            expression = "java(new AnnouncementPrivilegeId(announcementEntity.getId(), privilegeEntity.getId()))")
    @Mapping(target = "announcementEntity", source = "announcementEntity")
    @Mapping(target = "privilegeEntity", source = "privilegeEntity")
    @Mapping(target = "expiredAt", source = "expiredAt")
    AnnouncementPrivilegeEntity announcementPrivilegeBuilder(AnnouncementEntity announcementEntity,
                                                             PrivilegeEntity privilegeEntity,
                                                             LocalDateTime expiredAt);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "distanceType", source = "distanceType")
    @Mapping(target = "distanceUnit", source = "distanceUnit")
    @Mapping(target = "ccy", source = "ccy")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "ownership", source = "ownership")
    @Mapping(target = "seatCount", source = "seatCount")
    @Mapping(target = "conductorType", source = "conductorType")
    @Mapping(target = "motorSize", source = "motorSize")
    @Mapping(target = "gearBox", source = "gearBox")
    @Mapping(target = "year", source = "year")
    @Mapping(target = "motorPower", source = "motorPower")
    @Mapping(target = "vinCode", source = "vinCode")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "fullName", source = "fullName")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "model", source = "modelEntity.modelName")
    @Mapping(target = "brand",
            expression = "java(announcementEntity.getModelEntity().getBrandEntity().getBrandName())")
    @Mapping(target = "banType", source = "banTypeEntity.banName")
    @Mapping(target = "colour", source = "colourEntity.colourName")
    @Mapping(target = "city",source = "cityEntity.cityName")
    @Mapping(target = "conditions",
            expression = "java(announcementEntity.getConditionEntities().stream().map(c -> c.getConditionName()).collect(Collectors.toList()))")
    @Mapping(target = "equipments",
            expression = "java(announcementEntity.getEquipmentEntities().stream().map(e -> e.getEquipmentName()).collect(Collectors.toList()))")
    AnnouncementDto announcementEntityToDetailDto(AnnouncementEntity announcementEntity);
}
