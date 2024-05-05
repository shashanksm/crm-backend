package io.shashanksm.crm.customer.account.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "profile")
public class Profile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
    private String name;

	@Column(name = "email")
    private String email;

	@Column(name = "primary_contact")
    private String primaryContact;

	@Column(name = "email_verified")
    private boolean emailVerified;

	@Column(name = "contact_verified")
    private boolean primaryContactVerified;

	public Profile() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPrimaryContact() {
		return primaryContact;
	}

	public void setPrimaryContact(String primaryContact) {
		this.primaryContact = primaryContact;
	}

	public boolean isEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public boolean isPrimaryContactVerified() {
		return primaryContactVerified;
	}

	public void setPrimaryContactVerified(boolean primaryContactVerified) {
		this.primaryContactVerified = primaryContactVerified;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, emailVerified, id, name, primaryContact, primaryContactVerified);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profile other = (Profile) obj;
		return Objects.equals(email, other.email) && emailVerified == other.emailVerified
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(primaryContact, other.primaryContact)
				&& primaryContactVerified == other.primaryContactVerified;
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", name=" + name + ", email=" + email + ", primaryContact=" + primaryContact
				+ ", emailVerified=" + emailVerified + ", primaryContactVerified=" + primaryContactVerified + "]";
	}
    
    
    
    
}
