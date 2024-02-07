package com.myproject.mybankingsystem.authentication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank/auth")
@CrossOrigin("http://localhost:3000/")
public class TokenController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/response")
	public ResponseEntity<String> sayHello() {

		return ResponseEntity.ok("You are in secure place");
	}

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return this.userRepository.findAll();
	}

}
