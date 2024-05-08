package io.shashanksm.crm.customer.account.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.shashanksm.crm.customer.account.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{
	public void findByAccountId(Long accountId);
}
