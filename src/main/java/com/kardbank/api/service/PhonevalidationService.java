package com.kardbank.api.service;

import com.kardbank.api.dto.phoneValidation.Phonevalidation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PhonevalidationService {

    @Value("${abstractapi.apikey}")
    private String apiKey;

    @Value("${abstractapi.url}")
    private String urlAPi;

    public ResponseEntity<Phonevalidation> phonevalidation(String phoneNumber) {
        RestTemplate restTemplate = new RestTemplate();
        StringBuilder stringBuilder = new StringBuilder();
        String urlFinal = stringBuilder.append(urlAPi).append(apiKey).append("&phone=").append(phoneNumber).toString();
        ResponseEntity<Phonevalidation> entity = restTemplate.getForEntity(urlFinal, Phonevalidation.class);
        System.out.println(entity.getBody().valid());
        return entity;
    }




}
