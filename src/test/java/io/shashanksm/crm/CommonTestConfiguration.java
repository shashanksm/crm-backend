package io.shashanksm.crm;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

import io.shashanksm.crm.customer.account.configurations.LocalAccountsDataConfiguration;
import io.shashanksm.crm.customer.account.repositories.AccountProfileLinkRepository;

@Configuration
@Import({LocalAccountsDataConfiguration.class})
public class CommonTestConfiguration {


    @Autowired
    DataSource dataSource;

    @Bean
    AccountProfileLinkRepository accountProfileLinkRepository(){

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        return new AccountProfileLinkRepository(jdbcTemplate);
    }
}
