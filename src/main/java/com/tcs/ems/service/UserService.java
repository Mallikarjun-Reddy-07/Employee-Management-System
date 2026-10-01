package com.tcs.ems.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tcs.ems.dto.RegisterRequest;
import com.tcs.ems.entity.User;
import com.tcs.ems.repository.UserRepository;
import com.tcs.ems.util.EmailService;
import com.tcs.ems.util.OtpGenerator;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       EmailService emailService,
                       PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.emailService = emailService;
        this.passwordEncoder = passwordEncoder;
    }


    // ================= REGISTER =================

    public String register(RegisterRequest registerRequest) {

        Optional<User> existingUser =
                userRepository.findByEmail(registerRequest.getEmail());

        // If email already exists
        if (existingUser.isPresent()) {

            User oldUser = existingUser.get();

            // If already verified
            if (oldUser.isVerified()) {
                return "email_id already exists";
            }

            // If not verified, delete old user
            userRepository.delete(oldUser);
        }

        // Create new user
        User user = new User();

        user.setName(registerRequest.getName());
        user.setEmail(registerRequest.getEmail());

        // Encrypt password
        user.setPassword(
                passwordEncoder.encode(registerRequest.getPassword())
        );

        user.setRole("USER_ROLE");

        // User is not verified
        user.setVerified(false);

        // Generate OTP
        String otp = OtpGenerator.generateOtp();

        user.setOtp(otp);

        // OTP valid for 5 minutes
        user.setOtpexpirytime(
                LocalDateTime.now().plusMinutes(5)
        );

        // Save user
        userRepository.save(user);

        // Send OTP
        emailService.sendOtp(
                registerRequest.getEmail(),
                otp
        );

        return "Please check your email for OTP";
    }


    // ================= VERIFY OTP =================

    public String verifyOtp(String email, String otp) {

        Optional<User> optionalUser =
                userRepository.findByEmail(email);

        if (optionalUser.isEmpty()) {
            return "Email not found";
        }

        User user = optionalUser.get();

        // Check OTP
        if (user.getOtp() == null ||
                !user.getOtp().equals(otp)) {

            return "Invalid OTP";
        }

        // Check OTP expiry
        if (user.getOtpexpirytime() == null ||
                LocalDateTime.now()
                        .isAfter(user.getOtpexpirytime())) {

            return "OTP expired";
        }

        // Verify user
        user.setVerified(true);

        // Remove OTP after successful verification
        user.setOtp(null);
        user.setOtpexpirytime(null);

        // Save changes
        userRepository.save(user);

        return "Email verified successfully";
    }


    // ================= RESEND OTP =================

    public String resendOtp(String email) {

        Optional<User> optionalUser =
                userRepository.findByEmail(email);

        if (optionalUser.isEmpty()) {
            return "Email not found";
        }

        User user = optionalUser.get();

        // Don't resend if already verified
        if (user.isVerified()) {
            return "Email is already verified";
        }

        // Generate new OTP
        String newOtp = OtpGenerator.generateOtp();

        // Update OTP
        user.setOtp(newOtp);

        // New OTP valid for 5 minutes
        user.setOtpexpirytime(
                LocalDateTime.now().plusMinutes(5)
        );

        // Save
        userRepository.save(user);

        // Send new OTP
        emailService.sendOtp(
                email,
                newOtp
        );

        return "New OTP sent successfully";
    }
}