package io.shashanksm.crm.customer.account.entities;

public class AccountProfileLink {

    private Long id;

    private Long accountId;

    private Long profileId;

    public Long getId() {
        return id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public Long getProfileId() {
        return profileId;
    }

    public AccountProfileLink(Long id, Long accountId, Long profileId) {
        this.id = id;
        this.accountId = accountId;
        this.profileId = profileId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((accountId == null) ? 0 : accountId.hashCode());
        result = prime * result + ((profileId == null) ? 0 : profileId.hashCode());
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
        AccountProfileLink other = (AccountProfileLink) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (accountId == null) {
            if (other.accountId != null)
                return false;
        } else if (!accountId.equals(other.accountId))
            return false;
        if (profileId == null) {
            if (other.profileId != null)
                return false;
        } else if (!profileId.equals(other.profileId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "AccountProfileLink [id=" + id + ", accountId=" + accountId + ", profileId=" + profileId + "]";
    }

}
