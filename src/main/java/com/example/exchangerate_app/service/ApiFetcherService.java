package com.example.exchangerate_app.service;

import com.example.exchangerate_app.model.ApiResponseWrapper;
import org.springframework.scheduling.annotation.Scheduled;

public class ApiFetcherService {
    private final HttpClient httpClient;
    private final CurrencyService currencyService;

    public ApiFetcherService(HttpClient httpClient, CurrencyService currencyService) {
        this.httpClient = httpClient;
        this.currencyService = currencyService;
    }
}
