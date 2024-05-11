package io.shashanksm.crm.customer.account.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.shashanksm.crm.customer.account.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{
	
	@Query(value = "select a from Address a where a.account.id = :accountId")
	public List<Address> findByAccountId(Long accountId);
	
}
