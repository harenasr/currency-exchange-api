CREATE TABLE IF NOT EXISTS exchange_rate (
                                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                             moneda_origen VARCHAR(3) NOT NULL,
    moneda_destino VARCHAR(3) NOT NULL,
    tipo_cambio DECIMAL(10, 2) NOT NULL
    );
