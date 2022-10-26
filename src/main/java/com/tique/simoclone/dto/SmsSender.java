package com.tique.simoclone.dto;

public interface SmsSender {

    SmsResponse  sendSms(SmsRequest smsRequest);
}
