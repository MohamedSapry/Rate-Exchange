package rateexchangeapp;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.json.JSONObject;

public class CurrencyImpl implements Currency{
    @Override
    public int exchangeCurrencyData() {
        JSONObject jsonData = new JSONObject();
        try {
            URL url = new URL("https://freecurrencyapi.net/api/v2/latest?apikey=1b9dc950-67c2-11ec-818d-df835416afa6");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("charset", "utf-8");
            connection.connect();
            InputStream inStream = connection.getInputStream();
            String stringData = streamToString(inStream);
            jsonData = new JSONObject(stringData);

        }catch (IOException ex) {
            ex.printStackTrace();
        }

        return jsonData.getJSONObject("data").getInt("EGP");
    }
    private String streamToString(InputStream inputStream) {
        return new Scanner(inputStream, StandardCharsets.UTF_8).useDelimiter("\\Z").next();
    }
}
