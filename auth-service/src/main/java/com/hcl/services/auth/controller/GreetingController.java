package com.hcl.services.auth.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.services.auth.dto.AuthenticationRequest;
import com.hcl.services.auth.dto.AuthenticationResponse;
import com.hcl.services.auth.model.LoginUser;
import com.hcl.services.auth.repo.LoginUserRepository;
import com.hcl.services.auth.service.HclUserDetailsService;
import com.hcl.services.auth.utils.JwtUtil;

@RestController
@RequestMapping("/auth")
public class GreetingController {
	
	private Logger logger = LoggerFactory.getLogger(GreetingController.class);
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private HclUserDetailsService userDetailsService;
	
	@Autowired
	private LoginUserRepository repository;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@GetMapping("/")
	public ResponseEntity<?> sayHello(){
		return ResponseEntity.ok("Hello Welcome to Auth Service");
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> createAuthenticationToken(@RequestBody AuthenticationRequest request) throws Exception{
		logger.info("GC: creating authentication");
		try {
			logger.info("GC: AuthenticationManager\t" + request.getUsername() + "|" + request.getPassword());
			authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		} catch (AuthenticationException e) {
			logger.error("GC: " + e.getMessage());
			throw new Exception("Incorrect username and password ", e);
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
		final String jwtString = jwtUtil.generateToken(userDetails);
		logger.info("GC: JWT \t Bearer " + jwtString);
		return ResponseEntity.ok(new AuthenticationResponse(jwtString));
	}
	
	@PostMapping("/loginuser")
	public ResponseEntity<LoginUser> getLoginUserDetailsByUsername(@RequestBody AuthenticationRequest request) throws Exception{
		Optional<LoginUser> loginUser = repository.findByUsername(request.getUsername());
		if(!loginUser.isPresent()) {
			throw new Exception("Incorrect username and password ");
		}
		return ResponseEntity.ok(loginUser.get());
	}
}
