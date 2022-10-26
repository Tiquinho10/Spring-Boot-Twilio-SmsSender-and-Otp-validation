package com.tique.simoclone.services;

import com.tique.simoclone.entities.ConfirmationToken;
import com.tique.simoclone.entities.User;
import com.tique.simoclone.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    private final ConfirmationTokenService confirmationTokenService;
    private  final UserRepository userRepository;

   @Transactional(readOnly = true)
    public User findByPhoneNumber(String phoneNumber){
       Optional<User> obj = userRepository.findByPhoneNumber(phoneNumber);

       return obj.orElseThrow(
               () -> new IllegalStateException("User mot found")
       );

    }


//    String token = UUID.randomUUID().toString();

//    ConfirmationToken confirmationToken = new ConfirmationToken(
//            token,
//            LocalDateTime.now(),
//            LocalDateTime.now().plusMinutes(15)
//    );







        // Todo : para o user implementar uma logica findUserByPhoneNumber
       // return "confirmed";
   }

//    //save token
//}
