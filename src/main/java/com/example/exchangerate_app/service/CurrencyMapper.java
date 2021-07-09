package com.example.exchangerate_app.service;

import com.example.exchangerate_app.model.ApiResponseWrapperMinFin;
import com.example.exchangerate_app.model.ApiResponseWrapperMono;
import com.example.exchangerate_app.model.ApiResponseWrapperPrivat;
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

    public CurrencyModel mapFromMonoToModel(ApiResponseWrapperMono apiResponseWrapperMono) {
        CurrencyModel currencyModel = new CurrencyModel();
        currencyModel.setCurrencyName
                (getInstance(apiResponseWrapperMono.getCurrencyCodeA()).getCurrencyCode());
        currencyModel.setToCurrency
                (getInstance(apiResponseWrapperMono.getCurrencyCodeB()).getCurrencyCode());
        currencyModel.setDate(LocalDate.now().toString());
        if (apiResponseWrapperMono.getRateCross() != 0) {
            currencyModel.setAverageRate(apiResponseWrapperMono.getRateCross());
        } else {
            currencyModel.setAverageRate
                    ((apiResponseWrapperMono.getRateBuy() + apiResponseWrapperMono.getRateSell()) / 2);
        }
        return currencyModel;
    }

    public CurrencyModel mapFromPrivatToModel(ApiResponseWrapperPrivat apiResponseWrapperPrivat) {
        CurrencyModel currencyModel = new CurrencyModel();
        currencyModel.setCurrencyName(apiResponseWrapperPrivat.getCcy());
        currencyModel.setToCurrency(apiResponseWrapperPrivat.getBase_ccy());
        currencyModel.setDate(LocalDate.now().toString());
        currencyModel.setAverageRate
                ((apiResponseWrapperPrivat.getBuy() + apiResponseWrapperPrivat.getSale()) / 2);
        return currencyModel;
    }

    public CurrencyModel mapFromMinFinToModel(ApiResponseWrapperMinFin apiResponseWrapperMinFin) {
        CurrencyModel currencyModel = new CurrencyModel();
        currencyModel.setCurrencyName(apiResponseWrapperMinFin.getCurrency().toUpperCase());
        currencyModel.setToCurrency("UAH");
        currencyModel.setDate(LocalDate.now().toString());
        currencyModel.setAverageRate
                ((apiResponseWrapperMinFin.getAsk() + apiResponseWrapperMinFin.getBid()) / 2);
        return currencyModel;
    }
}
