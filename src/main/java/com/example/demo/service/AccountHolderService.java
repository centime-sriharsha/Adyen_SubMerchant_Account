package com.example.demo.service;

import com.adyen.model.marketpay.*;

public interface AccountHolderService {

    public CreateAccountHolderResponse createSubMerchant(CreateAccountHolderRequest createAccountHolder);
    public GetAccountHolderResponse getSubMerchant(String ahId);
    public UpdateAccountHolderResponse updateSubMerchant(UpdateAccountHolderRequest request);
    public SuspendAccountHolderResponse suspendSubMerchant(SuspendAccountHolderRequest request);
    public UnSuspendAccountHolderResponse unSuspendSubMerchant(UnSuspendAccountHolderRequest request);
    public CloseAccountHolderResponse closeSubMerchant(CloseAccountHolderRequest request);

}
