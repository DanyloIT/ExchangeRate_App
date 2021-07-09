package com.example.exchangerate_app.repository;

import com.example.exchangerate_app.model.CurrencyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import javax.transaction.Transactional;
import java.util.List;

public interface CurrencyRepository extends JpaRepository<CurrencyModel, Long> {
    List<CurrencyModel> findAllByDateBetween(String dateStart, String dateEnd);

    @Modifying
    @Transactional
    @Query("UPDATE CurrencyModel c SET c.averageRate = :rate " +
            "WHERE c.currencyName = :currencyName AND c.toCurrency = :toCurrencyName")
    void update(@Param("rate") float rate,
                @Param("currencyName") String currencyName,
                @Param("toCurrencyName") String toCurrencyName);

    @Query
    CurrencyModel getCurrencyModelByCurrencyNameAndToCurrency(String currencyName, String toCurrency);
}
