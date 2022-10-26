package com.tique.simoclone.controller;


import com.tique.simoclone.dto.SmsRequest;
import com.tique.simoclone.services.ToNameService;
import com.tique.simoclone.services.TwilioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/sms")
@AllArgsConstructor
public class TwilioController {

    private  final TwilioService service;

    private  final ToNameService toNameService;


    @PostMapping("send")
    public ResponseEntity<Void> sendSms(@RequestBody SmsRequest smsRequest){
       // service.sendSms(smsRequest);
        toNameService.SendOtp(smsRequest);

        return ResponseEntity.ok().build();
   }

   @PostMapping(value = "validate")
   public  ResponseEntity<SmsRequest> validateOtp(@RequestBody SmsRequest smsRequest){
    SmsRequest  request =  service.validateOtp(smsRequest);

        return  ResponseEntity.ok(request);
   }
}
