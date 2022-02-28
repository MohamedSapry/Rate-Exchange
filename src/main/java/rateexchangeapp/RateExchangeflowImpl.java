package rateexchangeapp;

import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;

import java.time.Duration;

public class RateExchangeflowImpl implements RateExchangeflow{
    ActivityOptions options = ActivityOptions.newBuilder()
            .setScheduleToCloseTimeout(Duration.ofSeconds(10))
            .build();

    private final Currency currency = Workflow.newActivityStub(Currency.class, options);
    private final exchangeCurrency exchangeCurrency = Workflow.newActivityStub(exchangeCurrency.class, options);

    @Override
    public Double getExchangeRate(Double amount) {
        double data = currency.exchangeCurrencyData();
        return exchangeCurrency.currencyInEgp(data,amount);
    }
}
