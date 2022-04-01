package com.simbirsoft.paymentservice.mappers;

import com.simbirsoft.paymentservice.models.dtos.AccountDto;
import com.simbirsoft.paymentservice.models.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountDto entityToDto(Account account, @MappingTarget AccountDto accountDto);

    Account dtoToEntity(AccountDto accountDto, @MappingTarget Account account);

}
