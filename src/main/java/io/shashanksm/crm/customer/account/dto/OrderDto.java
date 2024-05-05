package io.shashanksm.crm.customer.account.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class OrderDto {
	
	private Long id;
	
	private String orderType;
	
	private String status;
	
	private LocalDateTime created;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public OrderDto(Long id, String orderType, String status, LocalDateTime created) {
		super();
		this.id = id;
		this.orderType = orderType;
		this.status = status;
		this.created = created;
	}

	public OrderDto() {
		super();
	}

	@Override
	public String toString() {
		return "OrderDto [id=" + id + ", orderType=" + orderType + ", status=" + status + ", created=" + created + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(created, id, orderType, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDto other = (OrderDto) obj;
		return Objects.equals(created, other.created) && Objects.equals(id, other.id)
				&& Objects.equals(orderType, other.orderType) && Objects.equals(status, other.status);
	}
	
	
	
}
