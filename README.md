# currency-exchange-api
reto-indra-currency-exchange-api

POSTMAN

POST:
http://localhost:8080/api/exchange?nuevoTipoCambio=3.8&monedaOrigen=USD&monedaDestino=PEN

Response:
{
    "id": 1,
    "monedaOrigen": "USD",
    "monedaDestino": "PEN",
    "tipoCambio": 3.7
}


GET:
http://localhost:8080/api/exchange?monto=100&monedaOrigen=USD&monedaDestino=PEN

Response:
{
    "monto": 100.0,
    "montoTipoCambio": 370.0,
    "monedaOrigen": "USD",
    "monedaDestino": "PEN",
    "tipoCambio": 3.7
}

