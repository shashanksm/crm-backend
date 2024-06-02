package io.shashanksm.crm.customer.account.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import io.shashanksm.crm.customer.account.dto.AccountDto;
import io.shashanksm.crm.customer.account.dto.AddressDto;
import io.shashanksm.crm.customer.account.dto.OrderDto;
import io.shashanksm.crm.customer.account.dto.ProfileDto;
import io.shashanksm.crm.customer.account.entities.Account;
import io.shashanksm.crm.customer.account.entities.AccountProfileLink;
import io.shashanksm.crm.customer.account.entities.Profile;
import io.shashanksm.crm.customer.account.entities.Address;
import io.shashanksm.crm.customer.account.entities.Order;
import io.shashanksm.crm.customer.account.repositories.AccountProfileLinkRepository;
import io.shashanksm.crm.customer.account.repositories.AccountsRepository;
import io.shashanksm.crm.customer.account.repositories.AddressRepository;
import io.shashanksm.crm.customer.account.repositories.OrdersRepository;
import io.shashanksm.crm.customer.account.repositories.ProfileRepository;

@Service
@Transactional(isolation = Isolation.SERIALIZABLE)
public class SimpleAccountService implements AccountService {

    private static final Logger logger = LoggerFactory.getLogger(SimpleAccountService.class);

    private AccountsRepository accountsRepository;

    private ProfileRepository profileRepository;

    private AddressRepository addressRepository;

    private OrdersRepository ordersRepository;

    private AccountProfileLinkRepository accountProfileLinkRepository;

    public SimpleAccountService(AccountsRepository accountsRepository,
            ProfileRepository profileRepository,
            AddressRepository addressRepository, OrdersRepository ordersRepository,
            AccountProfileLinkRepository accountProfileLinkRepository) {
        super();
        this.accountProfileLinkRepository = accountProfileLinkRepository;
        this.accountsRepository = accountsRepository;
        this.addressRepository = addressRepository;
        this.ordersRepository = ordersRepository;
        this.profileRepository = profileRepository;
    }

    @Override
    public Optional<AccountDto> findAccountById(Long accountId) throws AccountOperationException {
        AccountDto accountDto;
        Optional<AccountDto> ret = Optional.empty();

        // bare bones
        Optional<Account> retrievedAccount = this.accountsRepository.findById(accountId);

        if (retrievedAccount.isEmpty()) {
            throw new AccountOperationException(4040L, "account with id : " + accountId + " does not exist",
                    "try with another valid ID");
        }

        accountDto = AccountDto.fromEntity(retrievedAccount.get());

        // get profile
        Optional<AccountProfileLink> accountProfileLinkOptional = this.accountProfileLinkRepository
                .findAccountProfileLinkByAccountId(accountId);

        if (accountProfileLinkOptional.isEmpty()) {

            logger.warn("anonymous account - no profile linked to this account");

        } else {

            Long profileId = accountProfileLinkOptional.get().getProfileId();
            Optional<Profile> retrievedProfileOptional = this.profileRepository.findById(profileId);
            retrievedProfileOptional.ifPresentOrElse(

                    // if profile present
                    (profile) -> {
                        ProfileDto profileDto = ProfileDto.fromEntity(profile);
                        accountDto.setProfile(profileDto);
                    },
                    // else
                    () -> {
                        logger.warn("missing profile - profileId (" + profileId
                                + ") retrieved from account-link table is invalid");
                    });

        }

        // addresses
        List<Address> addresses = this.addressRepository.findByAccountId(accountId);
        if (addresses != null) {
            List<AddressDto> addressDtos = addresses.stream()
                    .map(AddressDto::fromEntity)
                    .collect(Collectors.toList());

            accountDto.setAdresses(addressDtos);
        }

        // orders
        List<Order> orders = this.ordersRepository.findByAccountId(accountId);
        if (orders != null) {
            List<OrderDto> orderDtos = orders.stream()
                    .map(OrderDto::fromEntity)
                    .collect(Collectors.toList());

            accountDto.setOrders(orderDtos);
        }

        ret = Optional.of(accountDto);

        return ret;
    }

    @Override
    public Optional<AccountDto> findAccountByProfileId(Long profileId) throws AccountOperationException {

        logger.info("finding by profile will re-use findByAccountId() after retrieving profileId");

        Optional<AccountDto> ret = Optional.empty();

        var accountProfileLinkOptional = this.accountProfileLinkRepository.findAccountProfileLinkByProfileId(profileId);

        if (accountProfileLinkOptional.isPresent()) {

            return findAccountById(accountProfileLinkOptional.get().getAccountId());

        } else {
            logger.warn("profile-id : " + profileId + " does not exist in account_profile_t table");
        }

        return ret;
    }

    @Override
    public Optional<AccountDto> createAccount(AccountDto accountDto) throws AccountOperationException {
        Optional<AccountDto> ret = Optional.empty();

        logger.info("creating account");

        // check if account-id already exists
        if (accountDto.getId() != null) {
            Long accountId = accountDto.getId();
            boolean exists = this.accountsRepository.existsById(accountId);
            if (exists) {
                logger.warn("account with id " + accountId + " already exists. aborting operation");
                throw new AccountOperationException(409L, "account with id " + accountId + " already exists",
                        "if intention is to udate, use update/patch/put operation; if new account is to be created, simply omit id in request");
            }
        }

        //creating bare-bones account
        Account account = accountDto.toEntity();

        account = this.accountsRepository.save(account);

        //creating profile
        Profile profile = accountDto.getProfile().toEntity();
        profile = this.profileRepository.save(profile);

        //linking profile
        AccountProfileLink accountProfileLink = new AccountProfileLink(null, account.getId(), profile.getId());
        this.accountProfileLinkRepository.createAccountProfileLink(accountProfileLink);

        //saving addresses
        List<Address> addresses = accountDto.getAdresses()
        .stream()
        .map(AddressDto::toEntity)
        .collect(Collectors.toList());

        for(Address address: addresses){
            address.setAccount(account);
        }
        
        this.addressRepository.saveAll(addresses);
        
        //saving orders
        List<Order> orders = accountDto.getOrders()
        .stream()
        .map(OrderDto::toEntity)
        .collect(Collectors.toList());

        for(Order order: orders){
            order.setAccount(account);
        }
        this.ordersRepository.saveAll(orders);

        ret = Optional.of(accountDto);
        
        return ret;
    }

    @Override
    public Optional<AccountDto> updateAccount(AccountDto accountDto) throws AccountOperationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateAccount'");
    }

    @Override
    public Optional<AccountDto> deleteAccount(Long accountId) throws AccountOperationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAccount'");
    }

}
