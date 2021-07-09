package com.example.exchangerate_app.model;

import lombok.Data;

@Data
public class ApiResponseWrapperMono {
    private int currencyCodeA;
    private int currencyCodeB;
    private int date;
    private float rateSell;
    private float rateBuy;
    private float rateCross;
}
