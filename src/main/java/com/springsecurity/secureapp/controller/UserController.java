package com.springsecurity.secureapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springsecurity.secureapp.model.ApiResponse;
import com.springsecurity.secureapp.model.User;
import com.springsecurity.secureapp.repository.UserRepository;
@Controller

@RequestMapping("/api/auth")
public class UserController {
	
	 @Autowired
	 UserRepository userRepository;
	 
	 @Autowired
	 PasswordEncoder passwordEncoder;
	 
//	@PreAuthorize("permitAll()")
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody User user) {
		System.out.println("user " + user.getEmail());
		if (userRepository.existsByEmail(user.getEmail())) {
		      return new ResponseEntity<ApiResponse>(
		          new ApiResponse(false, "Email Address already in use!"), HttpStatus.BAD_REQUEST);
		    }
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return new ResponseEntity<ApiResponse>(
		          new ApiResponse(true, "User registered successfully"), HttpStatus.OK);
	}
}
