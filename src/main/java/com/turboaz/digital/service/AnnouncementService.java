package com.turboaz.digital.service;

import com.turboaz.digital.dao.entity.AnnouncementEntity;
import com.turboaz.digital.dao.entity.BanTypeEntity;
import com.turboaz.digital.dao.entity.CityEntity;
import com.turboaz.digital.dao.entity.ColourEntity;
import com.turboaz.digital.dao.entity.ModelEntity;
import com.turboaz.digital.dao.entity.PrivilegeEntity;
import com.turboaz.digital.dao.repo.AnnouncementPrivilegeRepo;
import com.turboaz.digital.dao.repo.AnnouncementRepo;
import com.turboaz.digital.dao.repo.BanTypeRepo;
import com.turboaz.digital.dao.repo.CityRepo;
import com.turboaz.digital.dao.repo.ColourRepo;
import com.turboaz.digital.dao.repo.ConditionRepo;
import com.turboaz.digital.dao.repo.EquipmentRepo;
import com.turboaz.digital.dao.repo.ModelRepo;
import com.turboaz.digital.dao.repo.PrivilegeRepo;
import com.turboaz.digital.mapper.AnnouncementMapper;
import com.turboaz.digital.mapper.CriteriaMapper;
import com.turboaz.digital.model.dto.AnnouncementCriteria;
import com.turboaz.digital.model.dto.AnnouncementDto;
import com.turboaz.digital.model.dto.AnnouncementRequest;
import com.turboaz.digital.model.dto.LightAnnouncementDto;
import com.turboaz.digital.model.dto.PageableDto;
import com.turboaz.digital.model.dto.PrivilegeDto;
import com.turboaz.digital.model.exceptions.NotFoundException;
import com.turboaz.digital.service.specification.AnnouncementSpecification;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import static java.util.stream.Collectors.toList;

@Slf4j
@Service
@Builder(toBuilder = true)
@RequiredArgsConstructor
public class AnnouncementService {
    private final AnnouncementRepo announcementRepo;
    private final ModelRepo modelRepo;
    private final BanTypeRepo banTypeRepo;
    private final ColourRepo colourRepo;
    private final CityRepo cityRepo;
    private final EquipmentRepo equipmentRepo;
    private final ConditionRepo conditionRepo;
    private final PrivilegeRepo privilegeRepo;
    private final AnnouncementPrivilegeRepo announcementPrivilegeRepo;


    public AnnouncementRequest createAnnouncement(AnnouncementRequest announcementRequest) {
        log.info("ActionLog.createAnnouncement.start");

        ModelEntity modelEntity = modelRepo.findById(announcementRequest.getModelId()).orElseThrow(() -> {
                    log.error("ActionLog.createAnnouncement.error Model not found, modelId {}",
                            announcementRequest.getModelId());
                    return new NotFoundException("Model not found");
                }
        );

        BanTypeEntity banTypeEntity = banTypeRepo.findById(announcementRequest.getBanTypeId()).orElseThrow(() -> {
                    log.error("ActionLog.createAnnouncement.error Ban type not found, banTypeId {}",
                            announcementRequest.getBanTypeId());
                    return new NotFoundException("Ban type not found");
                }
        );

        ColourEntity colourEntity = colourRepo.findById(announcementRequest.getColourId()).orElseThrow(() -> {
                    log.error("ActionLog.createAnnouncement.error Colour not found, colourId {}",
                            announcementRequest.getColourId());
                    return new NotFoundException("Colour not found");
                }
        );

        CityEntity cityEntity = cityRepo.findById(announcementRequest.getCityId()).orElseThrow(() -> {
                    log.error("ActionLog.createAnnouncement.error City not found, cityId {}",
                            announcementRequest.getCityId());
                    return new NotFoundException("City not found");
                }
        );

        AnnouncementEntity announcementEntity = announcementRepo.save(
                AnnouncementMapper.INSTANCE.buildAnnouncementEntity(
                        announcementRequest,
                        modelEntity,
                        banTypeEntity,
                        colourEntity,
                        cityEntity,
                        equipmentRepo.findAllById(announcementRequest.getEquipmentIds()),
                        conditionRepo.findAllById(announcementRequest.getConditionIds())
                )
        );

        log.info("ActionLog.createAnnouncement.end");
        return AnnouncementMapper.INSTANCE.announcementEntityToDto(announcementEntity);
    }


    public PageableDto<LightAnnouncementDto> getLightAnnouncements(Integer page,
                                                                   Integer size,
                                                                   AnnouncementCriteria announcementCriteria) {
        log.info("ActionLog.getAnnouncements.start");

        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<AnnouncementEntity> pageEntity = announcementRepo.findAll(
                new AnnouncementSpecification(announcementCriteria), pageRequest
        );


        log.info("ActionLog.getAnnouncements.end");
        return PageableDto.<LightAnnouncementDto>builder()
                .hasPrevious(pageEntity.hasPrevious())
                .hasNext(pageEntity.hasNext())
                .totalElements(pageEntity.getTotalElements())
                .totalPages(pageEntity.getTotalPages())
                .data(pageEntity.stream()
                        .map(CriteriaMapper.INSTANCE::announcementToLightDto)
                        .collect(toList()))
                .build();
    }

    public void addPrivilegeToAnnouncement(Long id, PrivilegeDto dto) {
        log.info("ActionLog.addPrivilege.start");

        AnnouncementEntity announcementEntity = announcementRepo.findById(id).orElseThrow(
                () -> new NotFoundException("Announcement couldn`t found.")
        );

        PrivilegeEntity privilegeEntity = privilegeRepo.findById(dto.getPrivilegeId()).orElseThrow(
                () -> new NotFoundException("Privilege couldn`t found.")
        );

        announcementPrivilegeRepo.save(
                AnnouncementMapper.INSTANCE.announcementPrivilegeBuilder(
                        announcementEntity, privilegeEntity, dto.getExpiredAt()
                )
        );

        log.info("ActionLog.addPrivilege.end");
    }

    public AnnouncementDto getAnnouncement(Long id) {
        log.info("ActionLog.getAnnouncement.start");

        AnnouncementEntity announcementEntity = announcementRepo.findById(id).orElseThrow(
                () -> new NotFoundException("Announcement couldn`t found.")
        );

        log.info("ActionLog.getAnnouncement.end");

        return AnnouncementMapper.INSTANCE.announcementEntityToDetailDto(announcementEntity);
    }
}
