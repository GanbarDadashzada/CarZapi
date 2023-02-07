package com.carzapi.digital.service;

import com.carzapi.digital.dao.entity.VerificationEntity;
import com.carzapi.digital.dao.repo.AnnouncementRepo;
import com.carzapi.digital.dao.repo.VerificationRepo;
import com.carzapi.digital.mapper.VerificationMapper;
import com.carzapi.digital.model.dto.VerificationDto;
import com.carzapi.digital.model.exceptions.NotFoundException;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Builder(toBuilder = true)
@RequiredArgsConstructor
public class LoginService {
    private final AnnouncementRepo announcementRepo;
    private final JavaMailSender mailSender;
    private final VerificationRepo verificationRepo;
    private final JwtService jwtService;

    public void sendVerification(VerificationDto verificationDto) {
        log.info("ActionLog.sendVerification.start");

        int random = (int) (Math.random() * (900000) + 100000);

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("turbo.az.test@gmail.com");
        simpleMailMessage.setTo(verificationDto.getEmail());
        simpleMailMessage.setSubject("Verification");
        simpleMailMessage.setText("Your verification code for Carzapi is: " + random);

        verificationDto.setToken(String.valueOf(random));
        verificationRepo.save(VerificationMapper.INSTANCE.dtoToEntity(verificationDto));

        mailSender.send(simpleMailMessage);
        log.info("ActionLog.sendVerification.end");
    }

    public String confirmVerification(VerificationDto verificationDto) {
        log.info("ActionLog.confirmVerification.start");

        VerificationEntity entity = verificationRepo.findByIdAndToken(
                VerificationMapper.INSTANCE.dtoToKey(verificationDto), verificationDto.getToken()
        ).orElseThrow(
                () -> new NotFoundException("Email or token is not correct"));

        verificationRepo.delete(entity);

        String jwtToken = jwtService.generateToken(verificationDto.getEmail());

        log.info("ActionLog.confirmVerification.end");
        return jwtToken;
    }
}
