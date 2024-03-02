package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


//This class is responsible for fetching the exchange rate using an API.
public class ExchangeRate {

	public static double getRate(String currencyCode) throws Exception {
		double rate = 0.0;
		String apiUrl = "https://v6.exchangerate-api.com/v6/1a52e53134238edb5914823d/latest/" + currencyCode;

		URL url = new URL(apiUrl);
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		JSONParser parser = new JSONParser();
		JSONObject responseObject = (JSONObject) parser.parse(reader);

		// Parse the JSON response and retrieve the rate
		JSONObject conversionRates = (JSONObject) responseObject.get("conversion_rates");
		Number rateNumber = (Number) conversionRates.get("USD"); // Use Number as an intermediate type
		rate = rateNumber.doubleValue(); // Explicitly convert to Double


		reader.close();
		return rate;
	}
}
