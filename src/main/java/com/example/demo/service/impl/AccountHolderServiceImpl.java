package com.example.demo.service.impl;

import com.adyen.model.marketpay.*;
import com.example.demo.Util.Headers;
import com.example.demo.service.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AccountHolderServiceImpl implements AccountHolderService {

    @Value("${adyen.route.baseurl}")
    private String url;
    @Value("${adyen.username}")
    private String username;
    @Value("${adyen.password}")
    private String password;

    @Autowired
    RestTemplate restTemplate;


    @Override
    public CreateAccountHolderResponse createSubMerchant(CreateAccountHolderRequest request) {

        HttpHeaders headers = Headers.createHeaders(username, password);
        HttpEntity<?> entity = new HttpEntity<>(request, headers);
        request.createDefaultAccount(true);
        CreateAccountHolderResponse response = restTemplate.exchange(
                url + "/" + "createAccountHolder", HttpMethod.POST, entity, CreateAccountHolderResponse.class).getBody();
        return response;
    }

    @Override
    public GetAccountHolderResponse getSubMerchant(String ahId) {
        GetAccountHolderRequest request = new GetAccountHolderRequest();
        request.setAccountHolderCode(ahId);
        HttpHeaders headers = Headers.createHeaders(username, password);
        HttpEntity<?> entity = new HttpEntity<>(request, headers);
        GetAccountHolderResponse response = restTemplate.exchange(
                url + "/" + "getAccountHolder", HttpMethod.POST, entity, GetAccountHolderResponse.class).getBody();
        return response;
    }

    @Override
    public UpdateAccountHolderResponse updateSubMerchant(UpdateAccountHolderRequest request) {
        HttpHeaders headers = Headers.createHeaders(username, password);
        HttpEntity<?> entity = new HttpEntity<>(request, headers);
        UpdateAccountHolderResponse response = restTemplate.exchange(
                url + "/" + "updateAccountHolder", HttpMethod.POST, entity, UpdateAccountHolderResponse.class).getBody();
        return response;
    }

    @Override
    public SuspendAccountHolderResponse suspendSubMerchant(SuspendAccountHolderRequest request) {

        HttpHeaders headers = Headers.createHeaders(username, password);
        HttpEntity<?> entity = new HttpEntity<>(request, headers);
        SuspendAccountHolderResponse response = restTemplate.exchange(
                url + "/" + "suspendAccountHolder", HttpMethod.POST, entity, SuspendAccountHolderResponse.class).getBody();
        return response;
    }


    @Override
    public UnSuspendAccountHolderResponse unSuspendSubMerchant(UnSuspendAccountHolderRequest request) {

        HttpHeaders headers = Headers.createHeaders(username, password);
        HttpEntity<?> entity = new HttpEntity<>(request, headers);
        UnSuspendAccountHolderResponse response = restTemplate.exchange(
                url + "/" + "unSuspendAccountHolder", HttpMethod.POST, entity, UnSuspendAccountHolderResponse.class).getBody();
        return response;
    }


    @Override
    public CloseAccountHolderResponse closeSubMerchant(CloseAccountHolderRequest request) {

        HttpHeaders headers = Headers.createHeaders(username, password);
        HttpEntity<?> entity = new HttpEntity<>(request, headers);
        CloseAccountHolderResponse response = restTemplate.exchange(
                url + "/" + "closeAccountHolder", HttpMethod.POST, entity, CloseAccountHolderResponse.class).getBody();
        return response;
    }

}
