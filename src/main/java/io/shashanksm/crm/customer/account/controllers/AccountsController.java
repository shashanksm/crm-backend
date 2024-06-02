package io.shashanksm.crm.customer.account.controllers;

import java.util.Optional;

import io.shashanksm.crm.customer.account.dto.AccountDto;

public interface AccountsController {
	
	public Optional<AccountDto> findAccountById(); 
	
}
