package com.example.exchangerate_app.service;

import com.example.exchangerate_app.model.ApiResponseWrapperMinFin;
import com.example.exchangerate_app.model.ApiResponseWrapperMono;
import com.example.exchangerate_app.model.ApiResponseWrapperPrivat;
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

    @Scheduled(cron = "*/20 * * * * *")
    public void fetchFromAllApis() {
        System.out.println("Data fetched!");
        fetchAllDataFromMonoApi();
        fetchAllDataFromPrivatApi();
        fetchAllDataFromMinFin();
    }

    public void fetchAllDataFromMonoApi() {
        String monoUrl = "https://api.monobank.ua/bank/currency";
        ApiResponseWrapperMono[] apiResponseWrapperMonos = httpClient.getMono(monoUrl,
                                                            ApiResponseWrapperMono[].class);
        for (ApiResponseWrapperMono apiResponseWrapperMono : apiResponseWrapperMonos) {
            currencyService.saveMono(apiResponseWrapperMono);
        }
    }

    public void fetchAllDataFromPrivatApi() {
        String privatUrl = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5";
        ApiResponseWrapperPrivat[] apiResponseWrapperPrivats = httpClient.getPrivat(privatUrl,
                                                            ApiResponseWrapperPrivat[].class);
        for (ApiResponseWrapperPrivat apiResponseWrapperPrivat : apiResponseWrapperPrivats) {
            currencyService.savePrivat(apiResponseWrapperPrivat);
        }
    }

    public void fetchAllDataFromMinFin() {
        String minFinUrl = "https://api.minfin.com.ua/mb/9645678f6b570479ef708a0fedfd9503bbf597bd/";
        ApiResponseWrapperMinFin[] apiResponseWrapperMinFins = httpClient.getMinFin(minFinUrl,
                ApiResponseWrapperMinFin[].class);
        for (ApiResponseWrapperMinFin apiResponseWrapperMinFin : apiResponseWrapperMinFins) {
            currencyService.saveMinFin(apiResponseWrapperMinFin);
        }
    }
}
