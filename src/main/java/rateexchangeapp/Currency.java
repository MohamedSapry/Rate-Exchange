package rateexchangeapp;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface Currency {

    @ActivityMethod
    double exchangeCurrencyData();
}
