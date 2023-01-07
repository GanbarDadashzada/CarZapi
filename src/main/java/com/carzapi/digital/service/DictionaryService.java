package com.carzapi.digital.service;

import com.carzapi.digital.dao.repo.BanTypeRepo;
import com.carzapi.digital.dao.repo.BrandRepo;
import com.carzapi.digital.dao.repo.CityRepo;
import com.carzapi.digital.dao.repo.ColourRepo;
import com.carzapi.digital.dao.repo.ModelRepo;
import com.carzapi.digital.mapper.DictionaryMapper;
import com.carzapi.digital.model.dto.DictionaryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Service
@RequiredArgsConstructor
public class DictionaryService {
    public final BanTypeRepo banTypeRepo;
    public final ColourRepo colourRepo;
    public final CityRepo cityRepo;
    public final BrandRepo brandRepo;
    public final ModelRepo modelRepo;

    public List<DictionaryDto> getColours () {
        log.info("ActionLog.getColours.start");
        return colourRepo.findAll()
                .stream()
                .map(DictionaryMapper.INSTANCE::colourEntityToDto)
                .collect(Collectors.toList());
    }

    public List<DictionaryDto> getBanType () {
        log.info("ActionLog.getBanType.start");
        return banTypeRepo.findAll()
                .stream()
                .map(DictionaryMapper.INSTANCE::banTypeEntityToDto)
                .collect(Collectors.toList());
    }

    public List<DictionaryDto> getCity () {
        log.info("ActionLog.getCity.start");
        return cityRepo.findAll()
                .stream()
                .map(DictionaryMapper.INSTANCE::cityEntityToDto)
                .collect(Collectors.toList());
    }

    public List<DictionaryDto> getBrand () {
        log.info("ActionLog.getBrand.start");
        return brandRepo.findAll()
                .stream()
                .map(DictionaryMapper.INSTANCE::brandEntityToDto)
                .collect(Collectors.toList());
    }

    public List<DictionaryDto> getModel (Long id) {
        log.info("ActionLog.getModel.start");
        return modelRepo.findByBrandId(id)
                .stream()
                .map(DictionaryMapper.INSTANCE::modelEntityToDto)
                .collect(Collectors.toList());
    }

}
