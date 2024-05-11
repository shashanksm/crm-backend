package io.shashanksm.crm.customer.account.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.shashanksm.crm.customer.account.entities.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
	
	@Query(value = "select p from Profile p where p.account.id = :accountId")
	public Optional<Profile> findByAccountId(Long accountId);
}
