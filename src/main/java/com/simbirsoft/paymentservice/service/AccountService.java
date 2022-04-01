package com.simbirsoft.paymentservice.service;

import com.simbirsoft.paymentservice.models.dtos.AccountDto;

public interface AccountService {
    void saveAccount(AccountDto accountDto);
    AccountDto getAccountById(Long id);
    void updateAccount(AccountDto accountDto);
    void  deleteAccount(Long id);
}
