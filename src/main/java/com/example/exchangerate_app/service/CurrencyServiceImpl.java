package com.example.exchangerate_app.service;

import com.example.exchangerate_app.model.ApiResponseWrapper;
import com.example.exchangerate_app.model.CurrencyModel;
import com.example.exchangerate_app.repository.CurrencyRepository;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.List;

@Component
public class CurrencyServiceImpl implements CurrencyService {
    private final CurrencyRepository currencyRepository;
    private final CurrencyMapper currencyMapper;

    public CurrencyServiceImpl(CurrencyRepository currencyRepository, CurrencyMapper mapper) {
        this.currencyRepository = currencyRepository;
        this.currencyMapper = mapper;
    }

    @Override
    public List<CurrencyModel> getAverageRate() {
        return currencyRepository.findAll();
    }

    @Override
    public List<CurrencyModel> getAverageRateOnPeriod(LocalDate fromDate, LocalDate toDate) {
        return currencyRepository.findAll();
    }

    public CurrencyModel save(ApiResponseWrapper apiResponseWrapper) {
        return currencyRepository.save(currencyMapper.mapToModel(apiResponseWrapper));
    }
}

