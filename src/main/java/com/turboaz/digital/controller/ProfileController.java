package com.turboaz.digital.controller;

import com.turboaz.digital.model.dto.LightAnnouncementDto;
import com.turboaz.digital.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/turbo-az-copy/profile")
public class ProfileController {
    private final ProfileService profileService;

    @GetMapping("/announcements")
    public List<LightAnnouncementDto> getRelatedAnnouncements (@RequestAttribute String email) {
        return profileService.getRelatedAnnouncements(email);
    }

}
