package io.shashanksm.crm.customer.account.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.shashanksm.crm.customer.account.entities.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
	
}
