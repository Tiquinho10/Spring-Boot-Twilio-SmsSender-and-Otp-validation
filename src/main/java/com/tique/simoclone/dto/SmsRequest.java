package com.tique.simoclone.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SmsRequest {

    private  String phoneNumber;
    private  String userName;
    private  String oneTimePassword;


}
