package com.indra.currencyexchange.service;

import com.indra.currencyexchange.model.ExchageRateResponse;
import com.indra.currencyexchange.model.ExchangeRate;
import com.indra.currencyexchange.repository.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExchangeService {

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    public ExchageRateResponse aplicarTipoCambio(double monto, String monedaOrigen, String monedaDestino) throws Exception {
        Optional<ExchangeRate> exchangeRate = exchangeRateRepository.findByMonedaOrigenAndMonedaDestino(monedaOrigen, monedaDestino);
        ExchageRateResponse exchageRateResponse = new ExchageRateResponse();

        if (exchangeRate.isPresent()) {
            exchageRateResponse.setMonto(monto);
            exchageRateResponse.setMontoTipoCambio(monto * exchangeRate.get().getTipoCambio());
            exchageRateResponse.setMonedaOrigen(monedaOrigen);
            exchageRateResponse.setMonedaDestino(monedaDestino);
            exchageRateResponse.setTipoCambio(exchangeRate.get().getTipoCambio());
            return exchageRateResponse;
        } else {
            throw new Exception("Tipo de cambio no encontrado");
        }
    }

    public ExchangeRate actualizarTipoCambio(String monedaOrigen, String monedaDestino, double nuevoTipoCambio) {
        Optional<ExchangeRate> exchangeRate = exchangeRateRepository.findByMonedaOrigenAndMonedaDestino(monedaOrigen, monedaDestino);
        ExchangeRate rate;
        if (exchangeRate.isPresent()) {
            rate = exchangeRate.get();
            rate.setTipoCambio(nuevoTipoCambio);
        } else {
            rate = new ExchangeRate();
            rate.setMonedaOrigen(monedaOrigen);
            rate.setMonedaDestino(monedaDestino);
            rate.setTipoCambio(nuevoTipoCambio);
        }
        return exchangeRateRepository.save(rate);
    }
}
