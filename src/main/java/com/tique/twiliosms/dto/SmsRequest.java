package com.tique.twiliosms.dto;

import lombok.Data;

@Data
public class SmsRequest {

    private  String phoneNumber;
    private  String userName;
    private  String oneTimePassword;


}
