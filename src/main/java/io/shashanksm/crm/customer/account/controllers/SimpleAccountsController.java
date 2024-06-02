package io.shashanksm.crm.customer.account.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.shashanksm.crm.customer.account.dto.AccountDto;
import io.shashanksm.crm.customer.account.services.AccountService;

@RestController
@RequestMapping("accounts")
public class SimpleAccountsController {

	private static final Logger logger = LoggerFactory.getLogger(SimpleAccountsController.class);
	
	private AccountService accountService;
	
	public SimpleAccountsController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@GetMapping("{accountId}")
	public Optional<AccountDto> findAccountById(@PathVariable Long accountId){
		return this.accountService.findAccountById(accountId);
	}
	
	
}
