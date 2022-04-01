package com.simbirsoft.paymentservice.models.dtos;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountDto {
    Long customerId;
    BigDecimal balance;
}
