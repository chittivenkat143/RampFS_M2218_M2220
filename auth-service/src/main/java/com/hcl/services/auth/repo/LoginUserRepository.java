package com.hcl.services.auth.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.services.auth.model.LoginUser;

@Repository
public interface LoginUserRepository extends JpaRepository<LoginUser, Long>{
	Optional<LoginUser> findByUsername(String username);			
}
