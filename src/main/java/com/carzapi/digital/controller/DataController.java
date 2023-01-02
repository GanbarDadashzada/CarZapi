package com.carzapi.digital.controller;

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
@RequestMapping("/api/v1/data")
public class DataController {
    private final DictionaryService dictionaryService;

    @GetMapping("/dictionary/colours")
    public List<DictionaryDto> getColour() {
        return dictionaryService.getColours();
    }

    @GetMapping("/dictionary/banTypes")
    public List<DictionaryDto> getBanType() {
        return dictionaryService.getBanType();
    }

    @GetMapping("/dictionary/gearboxes")
    public List<DictionaryDto> getGearbox() { return dictionaryService.getGearbox(); }

    @GetMapping("/dictionary/cities")
    public List<DictionaryDto> getCity() { return dictionaryService.getCity(); }

    @GetMapping("/dictionary/fuels")
    public List<DictionaryDto> getFuel() { return dictionaryService.getFuel(); }

    @GetMapping("/dictionary/brands")
    public List<DictionaryDto> getBrand() { return dictionaryService.getBrand(); }

    @GetMapping("/dictionary/brands/{id}/models")
    public List<DictionaryDto> getModels(@PathVariable Long id) {
        return dictionaryService.getModel(id);
    }
}
