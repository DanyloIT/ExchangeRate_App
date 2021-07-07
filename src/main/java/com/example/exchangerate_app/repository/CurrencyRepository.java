package com.example.exchangerate_app.repository;

import com.example.exchangerate_app.model.Currency;
import com.example.exchangerate_app.model.dto.CurrencyResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    List<CurrencyResponseDto> findCurrencyByDateBetween(LocalDate fromDate, LocalDate toDate);
}
