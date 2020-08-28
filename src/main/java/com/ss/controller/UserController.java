package com.ss.controller;

import com.ss.model.AuthToken;
import com.ss.model.JwtUserDetails;
import com.ss.model.LoginDto;
import com.ss.model.User;
import com.ss.repo.UserRepo;
import com.ss.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth/user")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthToken register(@RequestBody User user) {
        return jwtUtils.generateToken(userRepo.save(user));
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public AuthToken login(@RequestBody LoginDto loginDto) {
        Optional<User> userOpt = userRepo.findByUserName(loginDto.getUserName());
        if (userOpt.isPresent()) {
            User existingUser = userOpt.get();
            if (loginDto.getPassword().equals(existingUser.getPassword())) {
                return jwtUtils.generateToken(userRepo.save(existingUser));
            }
        }

        throw new RuntimeException("UserName not exist");
    }

    @GetMapping("/validate")
    public JwtUserDetails validate(@RequestHeader("x-auth-token") String authToken) {
        return jwtUtils.validateToken(authToken);
    }


}
