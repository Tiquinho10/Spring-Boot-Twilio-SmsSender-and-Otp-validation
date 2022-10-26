package com.tique.simoclone.config;



import com.tique.simoclone.entities.User;
import com.tique.simoclone.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class FirstUserConfig implements ApplicationRunner {

    private final Logger logger = LoggerFactory.getLogger(FirstUserConfig.class);
    private final UserRepository userRepository;
    //private BCryptPasswordEncoder passwordEncoder;

    public FirstUserConfig(UserRepository userRepository){ //BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        //this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (userRepository.count() != 0) {
            return;
        }


        logger.info("Nenhum usuário encontrado, cadastrando usuários padrão.");


        userRepository.save(
                new User(
                        "admin",
                        "123456",
                                "842883263"
        ));


    }
}


