package com.example.demo.service.impl;

import com.adyen.model.marketpay.*;
import com.example.demo.Util.Headers;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AccountServiceImpl implements AccountService {

    @Value("${adyen.route.baseurl}")
    private String url;
    @Value("${adyen.username}")
    private String username;
    @Value("${adyen.password}")
    private String password;

    @Autowired
    RestTemplate restTemplate;


    @Override
    public CreateAccountResponse createAccount(CreateAccountRequest request) {

        HttpHeaders headers = Headers.createHeaders(username, password);
        HttpEntity<?> entity = new HttpEntity<>(request, headers);
        CreateAccountResponse response = restTemplate.exchange(
                url + "/" + "createAccount", HttpMethod.POST, entity, CreateAccountResponse.class).getBody();
        return response;
    }

    @Override
    public UpdateAccountResponse updateAccount(UpdateAccountRequest request) {

        HttpHeaders headers = Headers.createHeaders(username, password);
        HttpEntity<?> entity = new HttpEntity<>(request, headers);
        UpdateAccountResponse response = restTemplate.exchange(
                url + "/" + "updateAccount", HttpMethod.POST, entity, UpdateAccountResponse.class).getBody();
        return response;
    }

    @Override
    public CloseAccountResponse closeAccount(CloseAccountRequest request) {

        HttpHeaders headers = Headers.createHeaders(username, password);
        HttpEntity<?> entity = new HttpEntity<>(request, headers);
        CloseAccountResponse response = restTemplate.exchange(
                url + "/" + "closeAccount", HttpMethod.POST, entity, CloseAccountResponse.class).getBody();
        return response;
    }
}
