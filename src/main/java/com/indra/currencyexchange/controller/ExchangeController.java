package com.indra.currencyexchange.controller;

import com.indra.currencyexchange.model.ExchangeRate;
import com.indra.currencyexchange.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/exchange")
public class ExchangeController {

    @Autowired
    private ExchangeService exchangeService;

    @GetMapping
    public ResponseEntity<?> aplicarTipoCambio(@RequestParam double monto,
                                               @RequestParam String monedaOrigen,
                                               @RequestParam String monedaDestino) {
        try{
        return ResponseEntity.ok(exchangeService.aplicarTipoCambio(monto, monedaOrigen, monedaDestino));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo de cambio no encontrado para las monedas especificadas.");
        }
    }

    @PostMapping
    public ResponseEntity<?> actualizarTipoCambio(@RequestParam String monedaOrigen,
                                                  @RequestParam String monedaDestino,
                                                  @RequestParam double nuevoTipoCambio) {
        ExchangeRate updatedRate = exchangeService.actualizarTipoCambio(monedaOrigen, monedaDestino, nuevoTipoCambio);
        return ResponseEntity.ok(updatedRate);
    }
}
