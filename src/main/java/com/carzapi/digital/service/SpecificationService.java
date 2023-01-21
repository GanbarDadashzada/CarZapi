package com.carzapi.digital.service;

import com.carzapi.digital.service.specification.AnnouncementSpecification;
import com.carzapi.digital.dao.entity.AnnouncementEntity;
import com.carzapi.digital.dao.repo.AnnouncementRepo;
import com.carzapi.digital.mapper.AnnouncementMapper;
import com.carzapi.digital.model.dto.AnnouncementDto;
import com.carzapi.digital.model.dto.AnnouncementCriteria;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class SpecificationService {
    private final AnnouncementRepo announcementRepo;

}