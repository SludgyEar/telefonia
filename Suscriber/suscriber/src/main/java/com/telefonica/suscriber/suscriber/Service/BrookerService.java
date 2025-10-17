package com.telefonica.suscriber.suscriber.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.telefonica.suscriber.suscriber.Models.BrookerRequest;

@Service
public class BrookerService {
    private final RestTemplate restTemplate = new RestTemplate();
    @Value("${brooker.url}")
    private String url;

    public void enviarAlBrooker(BrookerRequest request)
    {
        String brookerURL = url;
        restTemplate.postForEntity(brookerURL, request, Void.class);
    }
}
