package com.hcl.services.bank.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.services.bank.domain.Account;
import com.hcl.services.bank.domain.AccountType;
import com.hcl.services.bank.domain.dto.AccountDto;
import com.hcl.services.bank.exception.ResourceNotFoundException;
import com.hcl.services.bank.repo.AccountRepository;
import com.hcl.services.bank.repo.AccountTypeRepository;
import com.hcl.services.bank.service.IAccountService;

@Service
public class AccountService implements IAccountService {
	private static Logger logger = LoggerFactory.getLogger(AccountService.class);

	@Autowired
	private AccountRepository repository;
	
	@Autowired
	private AccountTypeRepository repositoryAT;

	@Override
	public void saveOrUpdateAccount(Account account) {
		logger.info("AS:saveOrUpdateAccount");
		repository.save(account);
	}

	@Override
	public Account getAccountById(Long accountId) {
		logger.info("AS:getAccountById:" + accountId);
		return repository.findById(accountId).orElseThrow(() -> new ResourceNotFoundException("Account not found"));
	}

	@Override
	public Account getAccountByAccountNumber(String accountNumber) {
		logger.info("AS:getAccountByAccountNumber:" + accountNumber);
		return repository.findByAccountNumber(accountNumber)
				.orElseThrow(() -> new ResourceNotFoundException("Account not found"));
	}

	@Override
	public List<Account> getAccountsByAccountType(Long accountType) {
		logger.info("AS:getAccountsByAccountCode:" + accountType);
		Optional<AccountType> accountTypeOpt = repositoryAT.findById(accountType);
		if(accountTypeOpt.isPresent()) {
			return repository.findByAccountType(accountTypeOpt.get());
		}else {
			throw new ResourceNotFoundException("Accounts not found by type "+accountType);
		}
	}
	
	@Override
	public AccountDto getAccountDtoById(Long accountId) {
		return null;//repository.findByAccountId(accountId);
	}

}
