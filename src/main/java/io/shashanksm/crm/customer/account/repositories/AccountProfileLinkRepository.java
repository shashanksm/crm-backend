package io.shashanksm.crm.customer.account.repositories;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import io.shashanksm.crm.customer.account.entities.AccountProfileLink;

@Repository
public class AccountProfileLinkRepository {

    private static final Logger logger = LoggerFactory.getLogger(AccountProfileLinkRepository.class);

    private JdbcTemplate jdbcTemplate;

    public AccountProfileLinkRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<AccountProfileLink> findAccountProfileLinkByAccountId(final Long accountId) {
        Optional<AccountProfileLink> ret = Optional.empty();

        String sql = """
                SELECT id, account, profile FROM account_profile_t where account = ?
                """;

        RowMapper<AccountProfileLink> rowMapper = (resultSet, rowNum) -> {
            return new AccountProfileLink(resultSet.getLong(1), resultSet.getLong(2), resultSet.getLong(3));
        };

        List<AccountProfileLink> accountProfileLinks = this.jdbcTemplate.query(sql, rowMapper, accountId);

        if(accountProfileLinks == null || accountProfileLinks.isEmpty()){
            logger.warn("no links present for accountId : "+accountId);
            return ret;
        }

        if(accountProfileLinks.size() > 1){
            logger.warn("multiple entries found for accountId : "+accountId);
        }

        ret = Optional.of(accountProfileLinks.getFirst());

        return ret;
    }

    public Optional<AccountProfileLink> findAccountProfileLinkByProfileId(final Long profileId) {
        Optional<AccountProfileLink> ret = Optional.empty();

        String sql = """
                SELECT id, account, profile FROM account_profile_t where profile = ?
                """;

        RowMapper<AccountProfileLink> rowMapper = (resultSet, rowNum) -> {
            return new AccountProfileLink(resultSet.getLong(1), resultSet.getLong(2), resultSet.getLong(3));
        };

        List<AccountProfileLink> accountProfileLinks = this.jdbcTemplate.query(sql, rowMapper, profileId);

        if(accountProfileLinks == null || accountProfileLinks.isEmpty()){
            logger.warn("no links present for profileId : "+profileId);
            return ret;
        }

        if(accountProfileLinks.size() > 1){
            logger.warn("multiple entries found for profileId : "+profileId);
        }

        ret = Optional.of(accountProfileLinks.getFirst());

        return ret;
    }

    public void createAccountProfileLink(final AccountProfileLink accountProfileLink){
        String sql = """
                INSERT INTO account_profile_t (account, profile) VALUES (?,?)
                """;
        int updated = this.jdbcTemplate.update(sql, accountProfileLink.getAccountId(), accountProfileLink.getProfileId());

        logger.info("inserted "+updated+" rows");

    }

}
