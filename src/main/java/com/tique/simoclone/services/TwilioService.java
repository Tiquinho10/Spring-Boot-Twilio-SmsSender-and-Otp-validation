package com.tique.simoclone.services;

import com.tique.simoclone.dto.SendSms;
import com.tique.simoclone.dto.SmsRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TwilioService {

    private final static Logger logger = LoggerFactory.getLogger(TwilioService.class);

    private  final SendSms  sendSms;

    private final TwilioOTPService otpService;

    public TwilioService(@Qualifier("twilio") SendSms sendSms, TwilioOTPService otpService) {
        this.sendSms =  sendSms;
        this.otpService = otpService;
    }

    public void sendSms(SmsRequest smsRequest, String otp){
         sendSms.sendSms(smsRequest, otp);
    }

    public SmsRequest validateOtp(SmsRequest smsRequest){
        logger.info("validate otp request:" + smsRequest);

        logger.info("current time: " + LocalDateTime.now());

         otpService.validateOTP(smsRequest.getOneTimePassword(), smsRequest.getUserName());

         return smsRequest;
    }
}
