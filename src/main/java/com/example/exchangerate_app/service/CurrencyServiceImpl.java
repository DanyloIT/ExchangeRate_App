package com.example.exchangerate_app.service;

import com.example.exchangerate_app.model.ApiResponseWrapperMinFin;
import com.example.exchangerate_app.model.ApiResponseWrapperMono;
import com.example.exchangerate_app.model.ApiResponseWrapperPrivat;
import com.example.exchangerate_app.model.CurrencyModel;
import com.example.exchangerate_app.repository.CurrencyRepository;
import org.springframework.stereotype.Component;
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
    public List<CurrencyModel> findAllBetweenDate(String fromDate, String toDate) {
        return currencyRepository.findAllByDateBetween(fromDate, toDate);
    }


    public CurrencyModel saveMono(ApiResponseWrapperMono apiResponseWrapperMono) {
        return currencyRepository.save(currencyMapper.mapFromMonoToModel(apiResponseWrapperMono));
    }

    @Override
    public void savePrivat(ApiResponseWrapperPrivat apiResponseWrapperPrivat) {
        CurrencyModel privatModel = currencyMapper
                .mapFromPrivatToModel(apiResponseWrapperPrivat);
        String currencyName = privatModel.getCurrencyName().equals("RUR") ? "RUB" : privatModel.getCurrencyName();
        String toCurrency = privatModel.getToCurrency();
        if (currencyName.equals("BTC")) {
            currencyRepository.save(privatModel);
        }
        CurrencyModel monoModel = currencyRepository
                .getCurrencyModelByCurrencyNameAndToCurrency(currencyName, toCurrency);
        float avgRate = (monoModel.getAverageRate() + privatModel.getAverageRate()) / 2;
        currencyRepository.update(avgRate, currencyName, toCurrency);
    }

    @Override
    public void saveMinFin(ApiResponseWrapperMinFin apiResponseWrapperMinFin) {
        CurrencyModel minFinModel = currencyMapper
                .mapFromMinFinToModel(apiResponseWrapperMinFin);
        String currencyName = minFinModel.getCurrencyName();
        String toCurrency = minFinModel.getToCurrency();
        CurrencyModel currentModel = currencyRepository
                .getCurrencyModelByCurrencyNameAndToCurrency(currencyName, toCurrency);
        float avgRate = (currentModel.getAverageRate() + minFinModel.getAverageRate()) / 2;
        currencyRepository.update(avgRate, currencyName, toCurrency);
    }
}

