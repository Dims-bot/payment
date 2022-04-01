package com.simbirsoft.paymentservice.repository.abstacts;

import com.simbirsoft.paymentservice.models.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
