package com.tique.twiliosms.dto;

public interface SmsSender {

    SmsResponse  sendSms(SmsRequest smsRequest);
}
