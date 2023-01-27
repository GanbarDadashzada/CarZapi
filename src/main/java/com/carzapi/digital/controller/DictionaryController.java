package com.carzapi.digital.controller;

import com.carzapi.digital.dao.entity.PrivilegeEntity;
import com.carzapi.digital.model.dto.DictionaryDto;
import com.carzapi.digital.service.DictionaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/car-zapi/dictionary")
public class DictionaryController {
    private final DictionaryService dictionaryService;

    @GetMapping("/colours")
    public List<DictionaryDto> getColour() {
        return dictionaryService.getColours();
    }

    @GetMapping("/banTypes")
    public List<DictionaryDto> getBanType() {
        return dictionaryService.getBanType();
    }

    @GetMapping("/cities")
    public List<DictionaryDto> getCity() { return dictionaryService.getCity(); }

    @GetMapping("/brands")
    public List<DictionaryDto> getBrand() { return dictionaryService.getBrand(); }

    @GetMapping("/equipments")
    public List<DictionaryDto> getEquipments() { return dictionaryService.getEquipment(); }

    @GetMapping("/conditions")
    public List<DictionaryDto> getConditions() { return dictionaryService.getCondition(); }

    @GetMapping("/privileges")
    public List<DictionaryDto> getPrivileges() { return dictionaryService.getPrivileges(); }

    @GetMapping("/brands/{id}/models")
    public List<DictionaryDto> getModels(@PathVariable Long id) {
        return dictionaryService.getModel(id);
    }
}
