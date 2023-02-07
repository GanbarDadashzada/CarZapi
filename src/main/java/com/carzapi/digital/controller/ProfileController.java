package com.carzapi.digital.controller;

import com.carzapi.digital.model.dto.LightAnnouncementDto;
import com.carzapi.digital.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/car-zapi/profile")
public class ProfileController {
    private final ProfileService profileService;

    @GetMapping("/announcements")
    public List<LightAnnouncementDto> getRelatedAnnouncements (@RequestAttribute String email) {
        return profileService.getRelatedAnnouncements(email);
    }

}
