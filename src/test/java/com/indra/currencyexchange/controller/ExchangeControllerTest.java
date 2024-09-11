package com.indra.currencyexchange.controller;

import com.indra.currencyexchange.controller.ExchangeController;
import com.indra.currencyexchange.model.ExchangeRate;
import com.indra.currencyexchange.service.ExchangeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ExchangeControllerTest {

    @Mock
    private ExchangeService exchangeService;

    @InjectMocks
    private ExchangeController exchangeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void actualizarTipoCambio() {
        String monedaOrigen = "USD";
        String monedaDestino = "EUR";
        double nuevoTipoCambio = 0.85;

        ExchangeRate updatedRate = new ExchangeRate();
        updatedRate.setMonedaOrigen(monedaOrigen);
        updatedRate.setMonedaDestino(monedaDestino);
        updatedRate.setTipoCambio(nuevoTipoCambio);

        when(exchangeService.actualizarTipoCambio(monedaOrigen, monedaDestino, nuevoTipoCambio))
                .thenReturn(updatedRate);

        ResponseEntity<?> response = exchangeController.actualizarTipoCambio(monedaOrigen, monedaDestino, nuevoTipoCambio);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedRate, response.getBody());
    }
}