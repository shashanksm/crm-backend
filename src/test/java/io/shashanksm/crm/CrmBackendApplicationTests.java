package io.shashanksm.crm;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import io.shashanksm.crm.customer.account.entities.Account;
import io.shashanksm.crm.customer.account.entities.Address;
import io.shashanksm.crm.customer.account.entities.Order;
import io.shashanksm.crm.customer.account.entities.Profile;
import io.shashanksm.crm.customer.account.repositories.AccountsRepository;

@SpringBootTest
@ActiveProfiles("test")
class CrmBackendApplicationTests {
	
	@Autowired
	private AccountsRepository accountsRepository;

	@Test
	void contextLoads() {
	}
	

}
