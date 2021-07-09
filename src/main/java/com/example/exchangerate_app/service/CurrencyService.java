package com.example.exchangerate_app.service;

import com.example.exchangerate_app.model.ApiResponseWrapperMinFin;
import com.example.exchangerate_app.model.ApiResponseWrapperMono;
import com.example.exchangerate_app.model.ApiResponseWrapperPrivat;
import com.example.exchangerate_app.model.CurrencyModel;
import java.util.List;

public interface CurrencyService {
    List<CurrencyModel> getAverageRate();

    List<CurrencyModel> findAllBetweenDate(String fromDate, String toDate);

    CurrencyModel saveMono(ApiResponseWrapperMono apiResponseWrapperMono);

    void savePrivat(ApiResponseWrapperPrivat apiResponseWrapperPrivat);

    void saveMinFin(ApiResponseWrapperMinFin apiResponseWrapperMinFin);
}
