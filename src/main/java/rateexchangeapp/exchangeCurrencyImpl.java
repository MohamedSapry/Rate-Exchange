package rateexchangeapp;

import org.json.JSONObject;

public class exchangeCurrencyImpl implements exchangeCurrency{

    @Override
    public Double currencyInEgp(double exchangeAmounts, Double amount) {
        return amount * exchangeAmounts;
    }
}
