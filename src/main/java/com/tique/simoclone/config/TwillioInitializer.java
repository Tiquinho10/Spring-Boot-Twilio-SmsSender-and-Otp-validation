package com.tique.simoclone.config;

import com.twilio.Twilio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class TwillioInitializer {

    private  final  static Logger logger = LoggerFactory.getLogger(TwillioInitializer.class);

    private  final TwilioConfig twilioConfig;

    public TwillioInitializer(TwilioConfig twilioConfig){
        this.twilioConfig =	twilioConfig;
    }
    @PostConstruct
    public void initTwilio(){
        Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken());

        logger.info("twilio connected successfully with account sid: " + twilioConfig.getAccountSid() + " and trial number: " + twilioConfig.getTrialNumber());
    }

}
