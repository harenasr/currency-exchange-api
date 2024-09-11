package com.indra.currencyexchange.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExchageRateResponse {
    private double monto;
    private double montoTipoCambio;
    private String monedaOrigen;
    private String monedaDestino;
    private double tipoCambio;

}
