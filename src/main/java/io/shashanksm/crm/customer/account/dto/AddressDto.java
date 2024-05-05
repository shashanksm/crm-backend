package io.shashanksm.crm.customer.account.dto;

import java.util.Objects;

public class AddressDto {
	
	private Long id;
	
	private String name;
	
	private String unitNumber;
	
	private String addressLine1;
	private String addressLine2;
	
	private String city;
	
	private String region;
	
	private String postalCode;

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

	public String getUnitNumber() {
		return unitNumber;
	}

	public void setUnitNumber(String unitNumber) {
		this.unitNumber = unitNumber;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public AddressDto(Long id, String name, String unitNumber, String addressLine1, String addressLine2, String city,
			String region, String postalCode) {
		super();
		this.id = id;
		this.name = name;
		this.unitNumber = unitNumber;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.region = region;
		this.postalCode = postalCode;
	}

	public AddressDto() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(addressLine1, addressLine2, city, id, name, postalCode, region, unitNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressDto other = (AddressDto) obj;
		return Objects.equals(addressLine1, other.addressLine1) && Objects.equals(addressLine2, other.addressLine2)
				&& Objects.equals(city, other.city) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(postalCode, other.postalCode) && Objects.equals(region, other.region)
				&& Objects.equals(unitNumber, other.unitNumber);
	}

	@Override
	public String toString() {
		return "AddressDto [id=" + id + ", name=" + name + ", unitNumber=" + unitNumber + ", addressLine1="
				+ addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city + ", region=" + region
				+ ", postalCode=" + postalCode + "]";
	}
	
	//TODO toEntity and fromEntity
}
