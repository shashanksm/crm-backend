package io.shashanksm.crm.customer.account.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "preference_t")
public class Preference {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "pkey")
	private String key;
	
	@Column(name = "pvalue")
	private String value;
	
	@Column(name = "account")
	private Long accountId;

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Preference() {
		super();
	}


	@Override
	public String toString() {
		return "Preference [id=" + id + ", key=" + key + ", value=" + value + ", accountId=" + accountId + "]";
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(accountId, id, key, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Preference other = (Preference) obj;
		return Objects.equals(accountId, other.accountId) && Objects.equals(id, other.id)
				&& Objects.equals(key, other.key) && Objects.equals(value, other.value);
	}

	public Preference(String key, String value) {
		super();
		this.id = 9999L;
		this.key = key;
		this.value = value;
	}

	public Preference(String key, String value, Long accountId) {
		super();
		this.key = key;
		this.value = value;
		this.accountId = accountId;
	}
	
	
	
}
