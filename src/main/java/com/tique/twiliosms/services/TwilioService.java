package com.tique.twiliosms.services;

import com.tique.twiliosms.dto.SmsSender;
import com.tique.twiliosms.dto.SmsRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TwilioService {

    private final static Logger logger = LoggerFactory.getLogger(TwilioService.class);

    private  final SmsSender smsSender;

    private final TwilioOTPService otpService;

    public TwilioService(@Qualifier("twilio") SmsSender smsSender, TwilioOTPService otpService) {
        this.smsSender = smsSender;
        this.otpService = otpService;
    }

    public void sendSms(SmsRequest smsRequest){
         smsSender.sendSms(smsRequest);
    }

    public SmsRequest validateOtp(SmsRequest smsRequest){
        logger.info("validate otp request:" + smsRequest);
         otpService.validateOTP(smsRequest.getOneTimePassword(), smsRequest.getUserName());

         return smsRequest;
    }
}
