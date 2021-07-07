package com.example.exchangerate_app.model.dto;

import lombok.Data;

@Data
public class CurrencyResponseDto {
    private String currencyName;
    private double rateCross;
}
