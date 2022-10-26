package com.tique.simoclone.services;


import com.tique.simoclone.entities.ConfirmationToken;
import com.tique.simoclone.repositories.ConfirmationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

   private final ConfirmationTokenRepository confirmationTokenRepository;


    public  void saveConfirmation(ConfirmationToken token){
      confirmationTokenRepository.save(token);
    }

    public  ConfirmationToken getToken(String token){
      Optional<ConfirmationToken> obj =  confirmationTokenRepository.findByToken(token);

       return  obj.orElseThrow(
               () -> new IllegalArgumentException("token not found")
       );
    }
}
