package rateexchangeapp;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;
import org.json.JSONObject;

@ActivityInterface
public interface Currency {

    @ActivityMethod
    int exchangeCurrencyData();
}
