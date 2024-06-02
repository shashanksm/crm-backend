package io.shashanksm.crm.customer.services;


import java.util.Optional;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;


import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import io.shashanksm.crm.customer.account.dto.AccountDto;
import io.shashanksm.crm.customer.account.services.AccountService;

@SpringBootTest
@ActiveProfiles({"test","local","dev"})
public class AccountServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(AccountServiceTest.class);

    @Autowired
    private AccountService accountService;

    @Test
    public void shouldFindAccount() {

        Optional<AccountDto> opt = this.accountService.findAccountById(39L);

        opt.ifPresentOrElse(
                (accountDto) -> {
                    System.out.println(accountDto.toString());
                    File file = Paths.get(".","test","out.json").toFile();
                    ObjectMapper objectMapper = new ObjectMapper();
                    objectMapper.registerModule(new JavaTimeModule());
                    
                    try {
						objectMapper.writeValue(file, accountDto);
					} catch (IOException e) {
						e.printStackTrace();
					}
                },
                () -> {
                    logger.error("nope");
                });

    }

}
