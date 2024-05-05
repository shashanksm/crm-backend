package io.shashanksm.crm.customer.account.services;

import java.util.Optional;

import io.shashanksm.crm.customer.account.dto.AccountDto;

public interface AccountService {
	
	public Optional<AccountDto> findAccountById(Long accountId) throws AccountOperationException;
	
	public Optional<AccountDto> findAccountByProfileId(Long profileId) throws AccountOperationException;
	
	public Optional<AccountDto> createAccount(AccountDto accountDto) throws AccountOperationException;
	
	public Optional<AccountDto> updateAccount(AccountDto accountDto) throws AccountOperationException;
	
	public Optional<AccountDto> deleteAccount(Long accountId) throws AccountOperationException; 
	
}
