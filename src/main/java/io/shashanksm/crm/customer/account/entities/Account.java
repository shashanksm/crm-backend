package io.shashanksm.crm.customer.account.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "type")
	private String type;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "account")
	private Profile profile;

	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "account", referencedColumnName = "id")
	private List<Address> adresses;

	@OneToMany
	@JoinColumn(name = "account", referencedColumnName = "id")
	private List<Order> orders;

	@Column(name = "created")
	private LocalDateTime created;

	@ElementCollection
	@CollectionTable(name = "preferences", joinColumns = {@JoinColumn(name="account", referencedColumnName = "id")})
	@MapKeyColumn(name = "key")
	@Column(name = "value")
	private Map<String, String> preferences;

	private LocalDateTime lastLogin;

	public Account() {
		super();
	}

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

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public List<Address> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Address> adresses) {
		this.adresses = adresses;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
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

	@Override
	public String toString() {
		return "Account [id=" + id + ", type=" + type + ", profile=" + profile + ", adresses=" + adresses + ", orders="
				+ orders + ", created=" + created + ", preferences=" + preferences + ", lastLogin=" + lastLogin + "]";
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
		Account other = (Account) obj;
		return Objects.equals(adresses, other.adresses) && Objects.equals(created, other.created)
				&& Objects.equals(id, other.id) && Objects.equals(lastLogin, other.lastLogin)
				&& Objects.equals(orders, other.orders) && Objects.equals(preferences, other.preferences)
				&& Objects.equals(profile, other.profile) && Objects.equals(type, other.type);
	}

}
