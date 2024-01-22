package com.rktpdyfk.TradingMatchingService.controller;

import com.rktpdyfk.TradingMatchingService.dto.EmailCheckDto;
import com.rktpdyfk.TradingMatchingService.dto.EmailRequestDto;
import com.rktpdyfk.TradingMatchingService.service.EmailSendService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Check;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequiredArgsConstructor
public class EmailController {
    private final EmailSendService mailService;
    @PostMapping ("/mailSend")
    public String mailSend(@RequestBody @Valid EmailRequestDto emailDto){
        System.out.println("이메일 인증 이메일 :"+emailDto.getEmail());
        return mailService.joinEmail(emailDto.getEmail());
    }
