package com.tique.simoclone.services;

import com.tique.simoclone.config.TwilioConfig;
import com.tique.simoclone.dto.OtpStatus;
import com.tique.simoclone.dto.SendSms;
import com.tique.simoclone.dto.SmsRequest;
import com.tique.simoclone.dto.SmsResponse;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service("twilio")
@AllArgsConstructor
public class TwilioOTPService implements SendSms {

      private final  static Logger logger = LoggerFactory.getLogger(TwilioOTPService.class);

      private  final TwilioConfig config;

  Map<String, String> otpMap = new HashMap<>();
    Map<String, LocalDateTime> otpMapExpiration = new HashMap<>();



    public  String validateOTP(String userInputOtp, String username){
        if (userInputOtp.equals(otpMap.get(username))){

            otpMap.remove(username, userInputOtp);
            return  "codigo valido, siga com o procedimento";
        }else {
           throw  new IllegalArgumentException("Codigo invalido, por favor tente novamente");
        }


    }

    //6 digit otp
    private  String generateOTP(){
         return  new DecimalFormat("0000")
                 .format(new Random().nextInt(9999));
    }

    @Override
    public void sendSms(SmsRequest smsRequest, String otp) {
        //SmsResponse smsResponse = null;
      //  try {
            //smsRequest.setCreatedAt(LocalDateTime.now());
            //smsRequest.setExpiresAt(LocalDateTime.now().plusMinutes(5));
            PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(config.getTrialNumber());
            //String otp = generateOTP();
            String otpMessage = "O codigo para recuperar a sua senha e: " + otp + " ,obrigado";
            //send Twilio sms
//            Message message  = Message
//                    .creator(to, from,otpMessage)
//                    .create();

            otpMap.put(smsRequest.getUserName(), otp);
            otpMapExpiration.put("expTime", smsRequest.getExpiresAt());

            //smsResponse = new SmsResponse(OtpStatus.DELIVERED, otpMessage);
           logger.info("Send sms " + smsRequest + " otp: " + otp);
//        }catch (Exception e){
//            smsResponse = new SmsResponse(OtpStatus.FAILED, e.getMessage());
//        }

        //return  Mono.just(smsResponse);
    }
}
