package com.example.exchangerate_app.repository;

import com.example.exchangerate_app.model.CurrencyModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<CurrencyModel, Long> {
}
