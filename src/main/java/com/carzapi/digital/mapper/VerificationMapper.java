package com.carzapi.digital.mapper;

import com.carzapi.digital.dao.entity.VerificationEntity;
import com.carzapi.digital.model.dto.VerificationDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface VerificationMapper {
    VerificationMapper INSTANCE = Mappers.getMapper(VerificationMapper.class);
    @Mapping(target = "token", source = "token")
    @Mapping(target = "email",
            expression = "java(verificationEntity.getId().getEmail())")
    VerificationDto entityToDto (VerificationEntity verificationEntity);

    @Mapping(target = "token", source = "verificationDto.token")
    @Mapping(target = "id.email", source = "verificationDto.email")
    VerificationEntity dtoToEntity (VerificationDto verificationDto);
}
