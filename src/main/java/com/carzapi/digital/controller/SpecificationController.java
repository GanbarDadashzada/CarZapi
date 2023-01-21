package com.carzapi.digital.controller;

import com.carzapi.digital.dao.entity.AnnouncementEntity;
import com.carzapi.digital.model.dto.AnnouncementDto;
import com.carzapi.digital.model.dto.AnnouncementCriteria;
import com.carzapi.digital.service.SpecificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/car-zapi/specification")
public class SpecificationController {
    private final SpecificationService specificationService;

}
