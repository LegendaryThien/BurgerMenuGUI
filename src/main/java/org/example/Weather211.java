package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


//This class is responsible for fetching weather information using an API.
public class Weather211 {
	public static double getCityWeather(String cityName) throws Exception {
		double temperature = 0.0;
		String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=7ceb00399fe06c46063d13a5257712bb&units=imperial";

		URL url = new URL(apiUrl);
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		JSONParser parser = new JSONParser();
		JSONObject responseObject = (JSONObject) parser.parse(reader);

		// Parse the JSON response and retrieve the temperature
		JSONObject main = (JSONObject) responseObject.get("main");
		Number tempNumber = (Number) main.get("temp"); // Use Number as an intermediate type
		temperature = tempNumber.doubleValue(); // Explicitly convert to Double

		reader.close();
		return temperature;
	}
}
