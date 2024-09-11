package com.indra.currencyexchange.service;

import com.indra.currencyexchange.model.ExchangeRate;
import com.indra.currencyexchange.repository.ExchangeRateRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class ExchangeServiceTest {

    @Mock
    private ExchangeRateRepository exchangeRateRepository;

    @InjectMocks
    private ExchangeService exchangeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testAplicarTipoCambio_TipoCambioNoExistente() {
        double monto = 100.0;
        String monedaOrigen = "USD";
        String monedaDestino = "EUR";

        when(exchangeRateRepository.findByMonedaOrigenAndMonedaDestino(monedaOrigen, monedaDestino))
                .thenReturn(Optional.empty());

        Exception exception = assertThrows(Exception.class, () -> {
            exchangeService.aplicarTipoCambio(monto, monedaOrigen, monedaDestino);
        });

        assertEquals("Tipo de cambio no encontrado", exception.getMessage());
    }
}