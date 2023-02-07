package com.turboaz.digital.mapper;

import com.turboaz.digital.dao.entity.BanTypeEntity;
import com.turboaz.digital.dao.entity.ConditionEntity;
import com.turboaz.digital.dao.entity.EquipmentEntity;
import com.turboaz.digital.dao.entity.ModelEntity;
import com.turboaz.digital.dao.entity.CityEntity;
import com.turboaz.digital.dao.entity.ColourEntity;
import com.turboaz.digital.dao.entity.BrandEntity;
import com.turboaz.digital.dao.entity.PrivilegeEntity;
import com.turboaz.digital.model.dto.DictionaryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DictionaryMapper {
    DictionaryMapper INSTANCE = Mappers.getMapper(DictionaryMapper.class);

    @Mapping(target = "name", source = "colourName")
    DictionaryDto colourEntityToDto(ColourEntity colourEntity);

    @Mapping(target = "name", source = "modelName")
    DictionaryDto modelEntityToDto(ModelEntity modelEntity);

    @Mapping(target = "name", source = "brandName")
    DictionaryDto brandEntityToDto(BrandEntity brandEntity);

    @Mapping(target = "name", source = "cityName")
    DictionaryDto cityEntityToDto(CityEntity cityEntity);

    @Mapping(target = "name", source = "banName")
    DictionaryDto banTypeEntityToDto(BanTypeEntity banTypeEntity);

    @Mapping(target = "name", source = "equipmentName")
    DictionaryDto equipmentEntityToDto (EquipmentEntity equipmentEntity);

    @Mapping(target = "name", source = "conditionName")
    DictionaryDto conditionEntityToDto (ConditionEntity conditionEntity);

    @Mapping(target = "name", source = "name")
    DictionaryDto privilegesEntityToDto(PrivilegeEntity privilegeEntity);
}
