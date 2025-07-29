package com.services;

import com.model.User;
import com.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    public User RegisterUser(String email, String rawPassword, String name){

        private final UserRepo userRepo;

        private final PasswordEncoder passwordEncoder;

        if(userRepo.findByEmail(email).isPresent()){
            throw new RuntimeException("Email Already Exists");
        }

        String EncodedPassword = passwordEncoder.encode(rawPassword);

        User user = new User();
        user.setEmail(email);
        user.setPassword(rawPassword);
        user.setName(name);

        return userRepo.save(user);
    }
}
