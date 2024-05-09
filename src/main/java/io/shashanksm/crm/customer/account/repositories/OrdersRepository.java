package io.shashanksm.crm.customer.account.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.shashanksm.crm.customer.account.entities.Order;

@Repository
public interface OrdersRepository extends JpaRepository<Order, Long>{
	
	@Query(value = "select o from Order o where o.account.id = :accountId")
	public List<Order> findByAccountId(Long accountId);
	
}
