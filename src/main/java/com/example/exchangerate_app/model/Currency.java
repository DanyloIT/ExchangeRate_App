package com.example.exchangerate_app.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String currencyName;
    private float rateSellToBaseCurrency;
    private float rateBuyToBaseCurrency;
    private double rateCross;
    private LocalDate date;
}
