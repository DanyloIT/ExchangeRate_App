package com.example.exchangerate_app.service;

import com.example.exchangerate_app.model.dto.CurrencyResponseDto;
import java.time.LocalDate;
import java.util.List;

public interface CurrencyService {
    List<CurrencyResponseDto> getAverageRate();

    List<CurrencyResponseDto> getAverageRateOnPeriod(LocalDate fromDate, LocalDate toDate);
}
