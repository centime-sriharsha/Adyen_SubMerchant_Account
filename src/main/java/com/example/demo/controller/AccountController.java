package com.example.demo.controller;

import com.adyen.model.marketpay.*;
import com.example.demo.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${service.route.account}")
public class AccountController  {

    @Autowired
    private AccountServiceImpl accountService;

    @PostMapping()
    public CreateAccountResponse createAccountHolder(@Validated @RequestBody CreateAccountRequest request) {
        return accountService.createAccount(request);
    }

    @PutMapping()
    public UpdateAccountResponse updateAccountHolder(@Validated @RequestBody UpdateAccountRequest request) {
        return accountService.updateAccount(request);
    }

    @PutMapping("/closeAccount")
    public CloseAccountResponse suspendAccountHolder(@Validated @RequestBody CloseAccountRequest request) {
        return accountService.closeAccount(request);
    }


}
