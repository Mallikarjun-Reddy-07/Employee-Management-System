package com.tcs.ems.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tcs.ems.dto.VerifyOtpRequest;
import com.tcs.ems.entity.User;
import com.tcs.ems.exception.InvalidOtpException;
import com.tcs.ems.exception.OtpAlreadyVerified;
import com.tcs.ems.exception.OtpExpiredException;
import com.tcs.ems.exception.OtpVerifiedException;
import com.tcs.ems.exception.UserNotFoundException;
import com.tcs.ems.repository.UserRepository;

@Service
public class OtpService {

    private final UserRepository userRepository;

    public OtpService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String verifyOtp(VerifyOtpRequest verifyOtpRequest) {
        Optional<User> optionalUser = userRepository.findByEmail(verifyOtpRequest.getEmail());

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            // Already verified
            if (user.getOtp() == null) {
                throw new OtpAlreadyVerified("Otp Already Verified");
            }

            // Invalid OTP
            if (!user.getOtp().equals(verifyOtpRequest.getOtp())) {
                throw new InvalidOtpException("Invalid Otp");
            }

            // Expired OTP
            if (LocalDateTime.now().isAfter(user.getOtpexpirytime())) {
                throw new OtpExpiredException("Otp Expired");
            }

            // Success case
            user.setVerified(true);
            user.setOtp(null);
            user.setOtpexpirytime(null);
            userRepository.save(user); // updating existing object

            throw new OtpVerifiedException("Otp verified successfully");
        } else {
            throw new UserNotFoundException("No user found");
        }
    }
}
