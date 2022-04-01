package com.simbirsoft.paymentservice.controllers;

import com.simbirsoft.paymentservice.models.dtos.AccountDto;
import com.simbirsoft.paymentservice.service.AccountService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/api/accounts")
public class AccountController {

    AccountService accountService;

    @PostMapping("/add")
    public ResponseEntity<?> addAccount(@Valid @RequestBody AccountDto accountDto) {
        accountService.saveAccount(accountDto);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAccount(@PathVariable Long id) {
        AccountDto accountDto = accountService.getAccountById(id);

        return ResponseEntity.ok().body(accountDto);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateAccount(@RequestBody AccountDto accountDto) {
        accountService.updateAccount(accountDto);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);

        return ResponseEntity.ok().body("Account with id " + id + " was deleted");
    }
}
