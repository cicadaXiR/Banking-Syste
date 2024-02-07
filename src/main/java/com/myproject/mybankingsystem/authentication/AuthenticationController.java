package com.myproject.mybankingsystem.authentication;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/bank/auth")
@CrossOrigin("http://localhost:3000/")
@RequiredArgsConstructor
public class AuthenticationController {
	
	 private final AuthenticationService service;
	 
	  @PostMapping("/register")
	  public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
	    return ResponseEntity.ok(service.register(request));
	  }
	  
	  @PostMapping("/authenticate")
	  public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request	) {
	    return ResponseEntity.ok(service.authenticate(request));
	  }

	  @PostMapping("/refresh-token")
	  public void refreshToken( HttpServletRequest request,HttpServletResponse response) throws IOException {
	    service.refreshToken(request, response);
	  }
}
