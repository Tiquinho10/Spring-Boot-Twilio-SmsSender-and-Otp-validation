package com.tique.simoclone.services;

import com.tique.simoclone.config.FirstUserConfig;
import com.tique.simoclone.dto.SmsRequest;
import com.tique.simoclone.entities.ConfirmationToken;
import com.tique.simoclone.entities.User;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Random;


@Service
@AllArgsConstructor
public class ToNameService {

    private final Logger logger = LoggerFactory.getLogger(ToNameService.class);
     private final UserService userService;

     private final TwilioService twilioService;

     private  final  ConfirmationTokenService tokenService;

     @Transactional
      public void SendOtp(SmsRequest smsRequest){
          String otp = generateOTP();
          User user = userService.findByPhoneNumber("842883263");

          ConfirmationToken token = new ConfirmationToken(
                  otp,
                  LocalDateTime.now(),
                  LocalDateTime.now().plusMinutes(5),
                  user
          );

         // tokenService.saveConfirmation(token);

          twilioService.sendSms(smsRequest, otp);

          logger.info("otp: " + otp);
          logger.info("sms request: " + smsRequest);
          logger.info("token " + token);


     }

     private  String generateOTP(){
          return  new DecimalFormat("0000")
                  .format(new Random().nextInt(9999));
     }

}
