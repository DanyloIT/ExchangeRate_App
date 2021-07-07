package com.example.exchangerate_app.service;

import com.example.exchangerate_app.model.ApiResponseWrapper;
import com.example.exchangerate_app.model.CurrencyModel;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.Currency;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class CurrencyMapper {

    private static Map<Integer, Currency> currencies = new HashMap<>();

    static {
        Set<Currency> set = Currency.getAvailableCurrencies();
        for (Currency currency : set) {
            currencies.put(currency.getNumericCode(), currency);
        }
    }

    public static Currency getInstance(Integer code) {
        return currencies.get(code);
    }

    public CurrencyModel mapToModel(ApiResponseWrapper apiResponseWrapper) {
        CurrencyModel currencyModel = new CurrencyModel();
        currencyModel.setCurrencyName
                (getInstance(apiResponseWrapper.getCurrencyCodeA()).getCurrencyCode());
        currencyModel.setToCurrency
                (getInstance(apiResponseWrapper.getCurrencyCodeB()).getCurrencyCode());
        currencyModel.setDate(LocalDate.now());
        currencyModel.setAverageRate
                ((apiResponseWrapper.getRateBuy() + apiResponseWrapper.getRateSell()) / 2);
        return currencyModel;
    }
}
