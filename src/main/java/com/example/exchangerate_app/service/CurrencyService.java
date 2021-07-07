package com.example.exchangerate_app.service;

import com.example.exchangerate_app.model.ApiResponseWrapper;
import com.example.exchangerate_app.model.CurrencyModel;
import java.time.LocalDate;
import java.util.List;

public interface CurrencyService {
    List<CurrencyModel> getAverageRate();

    List<CurrencyModel> getAverageRateOnPeriod(LocalDate fromDate, LocalDate toDate);

    CurrencyModel save(ApiResponseWrapper apiResponseWrapper);
}
