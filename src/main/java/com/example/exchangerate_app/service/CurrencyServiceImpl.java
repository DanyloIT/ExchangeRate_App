package com.example.exchangerate_app.service;

import com.example.exchangerate_app.model.dto.CurrencyResponseDto;
import com.example.exchangerate_app.repository.CurrencyRepository;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.List;

@Component
public class CurrencyServiceImpl implements CurrencyService {
    private final CurrencyRepository currencyRepository;

    public CurrencyServiceImpl(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public List<CurrencyResponseDto> getAverageRate() {
        CurrencyResponseDto USD = new CurrencyResponseDto();
        USD.setCurrencyName("USD");
        USD.setRateCross(27.65);
        CurrencyResponseDto EUR = new CurrencyResponseDto();
        EUR.setCurrencyName("EUR");
        EUR.setRateCross(33.65);
        return List.of(USD, EUR);
    }

    @Override
    public List<CurrencyResponseDto> getAverageRateOnPeriod(LocalDate fromDate, LocalDate toDate) {
        return currencyRepository.findCurrencyByDateBetween(fromDate, toDate);
    }
}
