package com.example.exchangerate_app.service;

import com.example.exchangerate_app.model.ApiResponseWrapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ApiFetcherService {
    private final HttpClient httpClient;
    private final CurrencyService currencyService;

    public ApiFetcherService(HttpClient httpClient, CurrencyService currencyService) {
        this.httpClient = httpClient;
        this.currencyService = currencyService;
    }

    @Scheduled(cron = "*/60 * * * * *")
    public void fetchAllDataFromApi() {
        String monoUrl = "https://api.monobank.ua/bank/currency";
        ApiResponseWrapper[] apiResponseWrappersMono = httpClient.get(monoUrl,
                                                            ApiResponseWrapper[].class);
        for (ApiResponseWrapper apiResponseWrapper : apiResponseWrappersMono) {
            currencyService.save(apiResponseWrapper);
        }
    }
}
