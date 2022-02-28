package rateexchangeapp;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CurrencyImpl implements Currency{
    @Override
    public double exchangeCurrencyData() {
        Map<String, Double> data = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            URL url = new URL("https://freecurrencyapi.net/api/v2/latest?apikey=1b9dc950-67c2-11ec-818d-df835416afa6");
            Map<String, Map<String, Double>> exchangeData = mapper.readValue(url, new TypeReference<>(){});
            data = exchangeData.get("data");
        }catch (IOException ex) {
            ex.printStackTrace();
        }

        return data.get("EGP");
    }
}
