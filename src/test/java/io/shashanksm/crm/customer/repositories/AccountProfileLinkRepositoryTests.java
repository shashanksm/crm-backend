package io.shashanksm.crm.customer.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import io.shashanksm.crm.CommonTestConfiguration;
import io.shashanksm.crm.customer.account.entities.AccountProfileLink;
import io.shashanksm.crm.customer.account.repositories.AccountProfileLinkRepository;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {CommonTestConfiguration.class})
@ActiveProfiles("test")
public class AccountProfileLinkRepositoryTests {

    private static final Logger logger = LoggerFactory.getLogger(AccountProfileLinkRepositoryTests.class);

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    AccountProfileLinkRepository accountProfileLinkRepository;

    @Test
    public void contextLoads(){
        for(String beanName : applicationContext.getBeanDefinitionNames()){
            logger.info(beanName);
        }
    }

    @Test
    public void shouldDoSomething(){
        //arrange
        AccountProfileLink expected = new AccountProfileLink(17L, 33L, 30L);

        //act
        AccountProfileLink actual = this.accountProfileLinkRepository.findAccountProfileLinkByAccountId(33L).get();

        //assert
        assertEquals(expected, actual);
    }

}
