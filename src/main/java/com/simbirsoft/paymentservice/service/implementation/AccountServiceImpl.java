package com.simbirsoft.paymentservice.service.implementation;

import com.simbirsoft.paymentservice.exceptions.EntityNotFoundException;
import com.simbirsoft.paymentservice.exceptions.EntityUniqueException;
import com.simbirsoft.paymentservice.mappers.AccountMapper;
import com.simbirsoft.paymentservice.models.dtos.AccountDto;
import com.simbirsoft.paymentservice.models.entity.Account;
import com.simbirsoft.paymentservice.repository.abstacts.AccountRepository;
import com.simbirsoft.paymentservice.service.AccountService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    AccountRepository accountRepository;
    AccountMapper accountMapper;

    @Override
    public void saveAccount(AccountDto accountDto) {
        if (!accountRepository.existsById(accountDto.getCustomerId())) {
            Account account = accountMapper.dtoToEntity(accountDto, new Account());
            accountRepository.save(account);
        } else {
            throw new EntityUniqueException("The account exists in the database");
        }
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("The account does not exist"));

        return accountMapper.entityToDto(account, new AccountDto());
    }

    @Override
    public void updateAccount(AccountDto accountDto) {
        Account account = accountRepository.findById(accountDto.getCustomerId())
                .orElseThrow(() -> new EntityNotFoundException("The account does not exist"));
        account.setBalance(accountDto.getBalance());

        accountRepository.save(account);
    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("The account does not exist"));

        accountRepository.delete(account);
    }
}
