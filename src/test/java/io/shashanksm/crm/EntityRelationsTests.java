package io.shashanksm.crm;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import io.shashanksm.crm.customer.account.entities.Account;
import io.shashanksm.crm.customer.account.entities.Address;
import io.shashanksm.crm.customer.account.entities.Order;
import io.shashanksm.crm.customer.account.entities.Profile;
import io.shashanksm.crm.customer.account.repositories.AccountsRepository;
import io.shashanksm.crm.customer.account.repositories.AddressRepository;
import io.shashanksm.crm.customer.account.repositories.OrdersRepository;

@SpringBootTest
@ActiveProfiles("test")
public class EntityRelationsTests {

	@Autowired
	private AccountsRepository accountsRepository;

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	OrdersRepository ordersRepository;

	@Test
	public void shouldCreateAccount() {

		Account newTestAccount = buildTestAccount();

		Account savedAccount = this.accountsRepository.save(newTestAccount);

		Address address = buildTestAddress();

		address.setAccount(savedAccount);

		this.addressRepository.save(address);

		this.accountsRepository.delete(savedAccount);

		assertTrue(true);
	}

	@Test
	public void shouldCreateOrder() {

		Account account = accountsRepository.findById(28L).get();

		Order order = buildTestOrder();
		
		order.setAccount(account);
		
		this.ordersRepository.save(order);
		
		
	}
	
	@Test
	public void shouldRetrieveOrdersFromAccountId() {
		List<Order> orders = this.ordersRepository.findByAccountId(28L);
		
		orders.forEach(System.out::println);
	}

	private Account buildTestAccount() {
		Account newTestAccount = new Account();

		newTestAccount.setCreated(LocalDateTime.now());

		newTestAccount.setId(9999L);

		newTestAccount.setLastLogin(LocalDateTime.now());

		newTestAccount.setStatus("ACTIVE");

		newTestAccount.setType("PREMIUM");

		Profile profile = new Profile();

		profile.setEmail("test@test.com");

		profile.setEmailVerified(false);

		profile.setId(9999L);

		profile.setName("test profile");

		profile.setPrimaryContact("test primary contact 989898");

		profile.setPrimaryContactVerified(true);

		newTestAccount.setProfile(profile);

		return newTestAccount;
	}

	private Address buildTestAddress() {

		Address address = new Address();
		address.setId(9090909L);
		address.setName("test");
		address.setUnitNumber("test");
		address.setAddressLine1("test");
		address.setAddressLine2("test");
		address.setCity("test");
		address.setPostalCode("test");
		address.setRegion("test");

		return address;
	}

	private Order buildTestOrder() {
		Order order = new Order();
		order.setAccount(null);
		order.setCreated(LocalDateTime.now());
		order.setId(898989L);
		order.setStatus("test");
		order.setType("test");
		order.setAccount(null);
		return order;
	}

}
