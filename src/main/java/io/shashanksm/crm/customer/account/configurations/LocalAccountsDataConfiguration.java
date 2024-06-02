package io.shashanksm.crm.customer.account.configurations;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource(value = "classpath:db-config.properties")
@Profile(value = {"local","dev","test"})
public class LocalAccountsDataConfiguration {
	
	private static final Logger logger = LoggerFactory.getLogger(LocalAccountsDataConfiguration.class);
	
	@Value("${db.url}")
	private String dbUrl;
	
	@Value("${db.user}")
	private String username;
	
	@Value("${db.password}")
	private String password;
	
	@Bean
	private static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean
	DataSource dataSource() {
		
		logger.info(dbUrl);
		logger.info(username);
		logger.info(password);
		DriverManagerDataSource d = new DriverManagerDataSource(dbUrl, username, password);
		return d;
	}

	
}
