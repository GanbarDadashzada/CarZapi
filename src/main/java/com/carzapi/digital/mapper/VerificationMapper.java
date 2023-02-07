package com.carzapi.digital.mapper;

import com.carzapi.digital.dao.entity.VerificationEntity;
import com.carzapi.digital.dao.entity.embedded.VerificationKey;
import com.carzapi.digital.model.dto.VerificationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface VerificationMapper {
    VerificationMapper INSTANCE = Mappers.getMapper(VerificationMapper.class);

    @Mapping(target = "token", source = "token")
    @Mapping(target = "id.email", source = "email")
    @Mapping(target = "id.type", source = "type")
    VerificationEntity dtoToEntity (VerificationDto verificationDto);

    @Mapping(target = "email", source = "email")
    @Mapping(target = "type", source = "type")
    VerificationKey dtoToKey (VerificationDto verificationDto);
}
