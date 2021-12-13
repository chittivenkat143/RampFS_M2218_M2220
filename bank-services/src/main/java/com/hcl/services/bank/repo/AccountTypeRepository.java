package com.hcl.services.bank.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.services.bank.domain.AccountType;

public interface AccountTypeRepository extends JpaRepository<AccountType, Long>{
	
}
