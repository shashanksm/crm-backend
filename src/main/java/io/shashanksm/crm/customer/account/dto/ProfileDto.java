package io.shashanksm.crm.customer.account.dto;

import io.shashanksm.crm.customer.account.entities.Profile;

public class ProfileDto {

    private Long id;

    private String name;

    private String email;

    private String primaryContact;

    private boolean emailVerified;

    private boolean primaryContactVerified;

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

    public ProfileDto() {
        super();
    }

    public ProfileDto(Long id, String name, String email, String primaryContact, boolean emailVerified,
            boolean primaryContactVerified) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.primaryContact = primaryContact;
        this.emailVerified = emailVerified;
        this.primaryContactVerified = primaryContactVerified;
    }

    @Override
    public String toString() {
        return "ProfileDto [id=" + id + ", name=" + name + ", email=" + email + ", primaryContact=" + primaryContact
                + ", emailVerified=" + emailVerified + ", primaryContactVerified=" + primaryContactVerified + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((primaryContact == null) ? 0 : primaryContact.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProfileDto other = (ProfileDto) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (primaryContact == null) {
            if (other.primaryContact != null)
                return false;
        } else if (!primaryContact.equals(other.primaryContact))
            return false;
        return true;
    }

    public Profile toEntity() {
    	Profile profile = new Profile();
    	
    	profile.setId(id);
    	profile.setEmail(email);
    	profile.setEmailVerified(emailVerified);
    	profile.setName(name);
    	profile.setPrimaryContact(primaryContact);
    	profile.setPrimaryContactVerified(primaryContactVerified);
    	
    	return profile;
    }
    
    public static ProfileDto fromEntity(Profile profile) {
    	ProfileDto ret = new ProfileDto();
    	ret.setEmail(profile.getEmail());
    	ret.setEmailVerified(profile.isEmailVerified());
    	ret.setId(profile.getId());
    	ret.setName(profile.getName());
    	ret.setPrimaryContact(profile.getPrimaryContact());
    	ret.setPrimaryContactVerified(profile.isPrimaryContactVerified());
    	return ret;
    }

}
