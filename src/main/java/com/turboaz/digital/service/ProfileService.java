package com.turboaz.digital.service;

import com.turboaz.digital.dao.repo.AnnouncementRepo;
import com.turboaz.digital.mapper.CriteriaMapper;
import com.turboaz.digital.model.dto.LightAnnouncementDto;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Builder(toBuilder = true)
@RequiredArgsConstructor
public class ProfileService {
    private final AnnouncementRepo announcementRepo;
    private final JwtService jwtService;

    public List<LightAnnouncementDto> getRelatedAnnouncements(String email) {
        log.info("ActionLog.getRelatedAnnouncements.start");


        List<LightAnnouncementDto> lightAnnouncementDtos = announcementRepo.findAllByEmail(email)
                .stream()
                .map(CriteriaMapper.INSTANCE::announcementToLightDto)
                .collect(Collectors.toList());

        log.info("ActionLog.getRelatedAnnouncements.end");
        return lightAnnouncementDtos;
    }
}
