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
	
	@Test
	void shouldCreateAccount() {
		
		Profile profile = new Profile();
		profile.setName("test-profile");
		profile.setEmail("test@test.com");
		profile.setEmailVerified(true);
		profile.setPrimaryContact("1234567890");
		profile.setPrimaryContactVerified(true);
		//profile.setId(9999L);
		
		Address address1 = new Address();
		address1.setAddressLine1("address line 1");
		address1.setAddressLine1("address line 2");
		address1.setCity("test-city");
		//address1.setId(9999L);
		address1.setName("home");
		address1.setPostalCode("1183");
		address1.setRegion("test-region");
		address1.setUnitNumber("22A");
		Address address2 = new Address();
		address2.setAddressLine1("address line 1");
		address2.setAddressLine1("address line 2");
		address2.setCity("test-city");
		//address2.setId(999L);
		address2.setName("office");
		address2.setPostalCode("1212");
		address2.setRegion("test-region");
		address2.setUnitNumber("22B");
		List<Address> addresses = new ArrayList<>();
		addresses.add(address1);
		addresses.add(address2);
		
		Order order1 = new Order();
		order1.setCreated(LocalDateTime.now());
		//order1.setId(181818L);
		order1.setOrderType("EXPRESS");
		order1.setStatus("IN_PROGRESS");
		Order order2 = new Order();
		order2.setCreated(LocalDateTime.now());
		//order2.setId(1818L);
		order2.setOrderType("REGULAR");
		order2.setStatus("IN_PROGRESS");
		List<Order> orders = new ArrayList<>();
		orders.add(order1);
		orders.add(order2);
		
		Map<String, String> preferences = new HashMap<>();
		preferences.put("theme", "dark");
		preferences.put("default payment", "card");
		
		Account account = new Account();
		account.setAdresses(addresses);
		account.setCreated(LocalDateTime.now());
		//account.setId(909090L);
		account.setLastLogin(LocalDateTime.now());
		account.setOrders(orders);
		account.setPreferences(preferences);
		account.setProfile(profile);
		account.setType("STANDARD");
		
		accountsRepository.save(account);
		
	}

}
