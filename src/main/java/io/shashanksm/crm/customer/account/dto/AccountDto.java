package io.shashanksm.crm.customer.account.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import io.shashanksm.crm.customer.account.entities.Account;
import io.shashanksm.crm.customer.account.entities.Preference;

public class AccountDto {

	private Long id;

	private String type;

	private ProfileDto profile;

	private List<AddressDto> adresses;

	private List<OrderDto> orders;

	private LocalDateTime created;

	private Map<String, String> preferences;

	private LocalDateTime lastLogin;
	
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ProfileDto getProfile() {
		return profile;
	}

	public void setProfile(ProfileDto profile) {
		this.profile = profile;
	}

	public List<AddressDto> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<AddressDto> adresses) {
		this.adresses = adresses;
	}

	public List<OrderDto> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderDto> orders) {
		this.orders = orders;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public Map<String, String> getPreferences() {
		return preferences;
	}

	public void setPreferences(Map<String, String> preferences) {
		this.preferences = preferences;
	}

	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public AccountDto(Long id, String type, ProfileDto profile, List<AddressDto> adresses, List<OrderDto> orders,
			LocalDateTime created, Map<String, String> preferences, LocalDateTime lastLogin) {
		super();
		this.id = id;
		this.type = type;
		this.profile = profile;
		this.adresses = adresses;
		this.orders = orders;
		this.created = created;
		this.preferences = preferences;
		this.lastLogin = lastLogin;
	}

	public AccountDto() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(adresses, created, id, lastLogin, orders, preferences, profile, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountDto other = (AccountDto) obj;
		return Objects.equals(adresses, other.adresses) && Objects.equals(created, other.created)
				&& Objects.equals(id, other.id) && Objects.equals(lastLogin, other.lastLogin)
				&& Objects.equals(orders, other.orders) && Objects.equals(preferences, other.preferences)
				&& Objects.equals(profile, other.profile) && Objects.equals(type, other.type);
	}
	
	
	
	@Override
	public String toString() {
		return "AccountDto [id=" + id + ", type=" + type + ", profile=" + profile + ", adresses=" + adresses
				+ ", orders=" + orders + ", created=" + created + ", preferences=" + preferences + ", lastLogin="
				+ lastLogin + ", status=" + status + "]";
	}

	// todo toEntity and fromEntity
	public Account toEntity() {
		Account account = new Account();
		
		account.setCreated(created);
		account.setId(id);
		account.setLastLogin(lastLogin);
		//profile, address & orders need to be set via profile-repository's methods
		account.setStatus(status);
		account.setType(type);
		
		return account;
	}
	
	public static AccountDto fromEntity(Account account) {
		AccountDto accountDto = new AccountDto();
		
		accountDto.setCreated(account.getCreated());
		accountDto.setId(account.getId());
		accountDto.setLastLogin(account.getLastLogin());
		accountDto.setStatus(account.getStatus());
		accountDto.setType(account.getType());
		
		Map<String, String> dtoPreferences = new HashMap<>();
		
		accountDto.setPreferences(dtoPreferences);
		
		return accountDto;
	}
}
