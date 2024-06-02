package io.shashanksm.crm.customer.account.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import io.shashanksm.crm.customer.account.entities.Preference;

public interface PreferenceRepository extends JpaRepository<Preference, Long>{
	
	@Query(value = "select p from Preference p where p.accountId = :accountId")
	public List<Preference> findByAccountId(Long accountId);
	
}
