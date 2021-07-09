package com.example.exchangerate_app.model;

import lombok.Data;

@Data
public class ApiResponseWrapperPrivat {
    private String ccy;
    private String base_ccy;
    private float buy;
    private float sale;
}
