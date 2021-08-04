package com.example.demo.service;

import com.adyen.model.marketpay.*;

public interface AccountService {

    public CreateAccountResponse createAccount(CreateAccountRequest request);
    public UpdateAccountResponse updateAccount(UpdateAccountRequest request);
    public CloseAccountResponse closeAccount(CloseAccountRequest request);

}
