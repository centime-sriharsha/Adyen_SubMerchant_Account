package com.example.demo.controller;

import com.adyen.model.marketpay.*;
import com.example.demo.service.impl.AccountHolderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${service.route.accountHolder}")
public class AccountHolderController  {

    @Autowired
    private AccountHolderServiceImpl accountService;

    @PostMapping()
    public CreateAccountHolderResponse createAccountHolder(@Validated @RequestBody CreateAccountHolderRequest request) {
        return accountService.createSubMerchant(request);
    }

    @PutMapping()
    public UpdateAccountHolderResponse createAccountHolder(@Validated @RequestBody UpdateAccountHolderRequest request) {
        return accountService.updateSubMerchant(request);
    }

    @PutMapping("/suspendAccountHolder")
    public SuspendAccountHolderResponse suspendAccountHolder(@Validated @RequestBody SuspendAccountHolderRequest request) {
        return accountService.suspendSubMerchant(request);
    }


    @PutMapping("/unSuspendAccountHolder")
    public UnSuspendAccountHolderResponse unSuspendAccountHolder(@Validated @RequestBody UnSuspendAccountHolderRequest request) {
        return accountService.unSuspendSubMerchant(request);
    }


    @PutMapping("/closeAccountHolder")
    public CloseAccountHolderResponse unSuspendAccountHolder(@Validated @RequestBody CloseAccountHolderRequest request) {
        return accountService.closeSubMerchant(request);
    }

    @GetMapping("/{ahId}")
    public GetAccountHolderResponse getAccountHolder(@PathVariable String ahId) {
        return accountService.getSubMerchant(ahId);
    }


}
