package com.tcs.ems.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.ems.dto.RegisterRequest;
import com.tcs.ems.dto.VerifyOtpRequest;
import com.tcs.ems.service.OtpService;
import com.tcs.ems.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final OtpService otpService;

    // Constructor injection
    public UserController(UserService userService,
                          OtpService otpService) {

        this.userService = userService;
        this.otpService = otpService;
    }


    // ================= REGISTER =================

    @PostMapping("/register")
    public String register(
            @RequestBody RegisterRequest registerRequest) {

        return userService.register(registerRequest);
    }


    // ================= VERIFY OTP =================

    @PostMapping("/verify-otp")
    public String verifyOtp(
            @RequestBody VerifyOtpRequest verifyOtpRequest) {

        return otpService.verifyOtp(verifyOtpRequest);
    }


    // ================= RESEND OTP =================

    @PostMapping("/resend-otp")
    public String resendOtp(
            @RequestParam String email) {

        return userService.resendOtp(email);
    }
}