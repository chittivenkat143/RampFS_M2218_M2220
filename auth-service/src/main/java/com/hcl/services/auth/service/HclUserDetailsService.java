package com.hcl.services.auth.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hcl.services.auth.model.HclUserDetails;
import com.hcl.services.auth.model.LoginUser;
import com.hcl.services.auth.repo.LoginUserRepository;

@Service
public class HclUserDetailsService implements UserDetailsService{
	private Logger logger = LoggerFactory.getLogger(HclUserDetailsService.class);
	
	@Autowired
	private LoginUserRepository repositoryLogin;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("HUDS: loadUserByUsername(" + username + ")");
		Optional<LoginUser> user = repositoryLogin.findByUsername(username);		
		logger.info("HUDS: LoginUser" + user.toString());
		user.orElseThrow(()-> new UsernameNotFoundException("Not found " +username));		
		return user.map(HclUserDetails::new).get();
	}

}
