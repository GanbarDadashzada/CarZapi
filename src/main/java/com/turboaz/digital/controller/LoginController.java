package com.turboaz.digital.controller;

import com.turboaz.digital.model.dto.VerificationDto;
import com.turboaz.digital.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/turbo-az-copy/auth")
public class LoginController {
    private final LoginService loginService;

    @PostMapping("/send-verification")
    public void sendVerification (@RequestBody VerificationDto verificationDto) {
        loginService.sendVerification(verificationDto);
    }

    @PostMapping("/confirm-verification")
    public String confirmVerification (@RequestBody VerificationDto verificationDto) {
        return loginService.confirmVerification(verificationDto);
    }


}
