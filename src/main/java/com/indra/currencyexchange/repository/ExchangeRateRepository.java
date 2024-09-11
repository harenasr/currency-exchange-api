package com.indra.currencyexchange.repository;

import com.indra.currencyexchange.model.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {
    Optional<ExchangeRate> findByMonedaOrigenAndMonedaDestino(String monedaOrigen, String monedaDestino);
}
