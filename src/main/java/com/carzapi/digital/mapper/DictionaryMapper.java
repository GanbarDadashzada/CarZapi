package com.carzapi.digital.mapper;

import com.carzapi.digital.dao.entity.BanTypeEntity;
import com.carzapi.digital.dao.entity.ModelEntity;
import com.carzapi.digital.dao.entity.CityEntity;
import com.carzapi.digital.dao.entity.ColourEntity;
import com.carzapi.digital.dao.entity.BrandEntity;
import com.carzapi.digital.model.dto.DictionaryDto;
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
}
