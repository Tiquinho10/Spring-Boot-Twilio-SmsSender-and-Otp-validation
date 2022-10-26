package com.tique.simoclone.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SmsRequest {

    private  String phoneNumber;
    private  String userName;
    private String userPhoneNumber;
    private  String oneTimePassword;
    private LocalDateTime createdAt;
    private  LocalDateTime expiresAt;


}
