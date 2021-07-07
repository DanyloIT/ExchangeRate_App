package com.example.exchangerate_app.controller;

import com.example.exchangerate_app.model.CurrencyModel;
import com.example.exchangerate_app.service.CurrencyService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/rates")
public class CurrencyController {
    private static final String DATE_PATTERN = "dd.MM.yyyy";
    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/average")
    public List<CurrencyModel> getAverageRate() {
        return currencyService.getAverageRate();
    }

    @GetMapping("/average-in-period")
    public List<CurrencyModel> getAverageRateOnPeriod(@RequestParam
                                                            @DateTimeFormat(pattern = DATE_PATTERN)
                                                                        LocalDate fromDate,
                                                            @RequestParam
                                                            @DateTimeFormat(pattern = DATE_PATTERN)
                                                                    LocalDate toDate) {
        return currencyService.getAverageRateOnPeriod(fromDate, toDate);
    }
}
