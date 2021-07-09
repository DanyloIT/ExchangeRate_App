package com.example.exchangerate_app.model;

import lombok.Data;

@Data
public class ApiResponseWrapperMinFin {
    private String currency;
    private float ask;
    private float bid;
}
