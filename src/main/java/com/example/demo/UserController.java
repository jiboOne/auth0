package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private Auth0Service auth0Service;

	@PostMapping("/register")
	public void registerUser(@RequestBody RegisterUserRequest registerRequest) {
		auth0Service.registerUser(registerRequest.getEmail(), registerRequest.getPassword());
	}
}
