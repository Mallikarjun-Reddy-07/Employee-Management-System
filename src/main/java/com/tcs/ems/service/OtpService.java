package com.tcs.ems.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tcs.ems.dto.VerifyOtpRequest;
import com.tcs.ems.entity.User;
import com.tcs.ems.exception.InvalidOtpException;
import com.tcs.ems.exception.UserNotFoundException;
import com.tcs.ems.repository.UserRepository;

@Service
public class OtpService {
	
	private UserRepository userRepository;
	
	public OtpService(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	public String VerifyOtp(VerifyOtpRequest verifyOtpRequest) {
		Optional<User> optionaluser=userRepository.findByEmail(verifyOtpRequest.getEmail());
		if(optionaluser.isPresent()) {
			User user=optionaluser.get();
			if(!user.getOtp().equals(verifyOtpRequest.getOtp())) {
				 throw new InvalidOtpException("Invalid Otp");
			}
			
			if(LocalDateTime.now().isAfter(user.getOtpexpirytime())) {
				return "Otp Expired";
			}
			
			else {
				user.setVerified(true);
				user.setOtp(null);
				user.setOtpexpirytime(null);
				userRepository.save(user);// updating existing object
				return "Otp verified Sucessfully";
			}
			
		}else {
			throw new UserNotFoundException( "no user found");
		}
	}
	
}
