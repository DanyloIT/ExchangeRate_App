package com.example.exchangerate_app.controller;

import com.example.exchangerate_app.model.CurrencyModel;
import com.example.exchangerate_app.service.CurrencyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/rates")
public class CurrencyController {
    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/average")
    public List<CurrencyModel> getAverageRate() {
        return currencyService.getAverageRate();
    }

    @GetMapping("/average-in-period")
    public List<CurrencyModel> getAverageRateOnPeriod(@RequestParam String fromDate,
                                                            @RequestParam String toDate) {
        return currencyService.findAllBetweenDate(fromDate, toDate);
    }
}
