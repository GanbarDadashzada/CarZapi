package com.carzapi.digital.service;

import com.carzapi.digital.dao.entity.VerificationEntity;
import com.carzapi.digital.dao.repo.AnnouncementRepo;
import com.carzapi.digital.dao.repo.VerificationRepo;
import com.carzapi.digital.mapper.VerificationMapper;
import com.carzapi.digital.model.dto.VerificationDto;
import com.carzapi.digital.model.enums.VerificationType;
import com.carzapi.digital.model.exceptions.NotFoundException;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service
@Builder(toBuilder = true)
@RequiredArgsConstructor
public class LoginService {
    private final AnnouncementRepo announcementRepo;
    private final JavaMailSender mailSender;
    private final VerificationRepo verificationRepo;

    public void sendVerification (VerificationDto verificationDto) {
        log.info("ActionLog.sendVerification.start");

        int min = 100000;
        int max = 999999;
        int random = (int)(Math.random()*(max - min + 1) + min);

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("turbo.az.test@gmail.com");
        simpleMailMessage.setTo(verificationDto.getEmail());
        simpleMailMessage.setSubject("Verification");
        simpleMailMessage.setText("Your verification code for Carzapi is: " + random);

        verificationRepo.save(VerificationMapper.INSTANCE.dtoToEntity(verificationDto));

        mailSender.send(simpleMailMessage);
        log.info("ActionLog.sendVerification.end");
    }
}
