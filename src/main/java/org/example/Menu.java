package org.example;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Currency;
public class Menu extends Burger211 {

	String country;
	String franchise;
	double discountRate;
	double exchangeRate;
	double temperature;
	String currencyCode;
	String currencySymbol;
	int tooHotTemperature;

	private String promotionText = "";

	public Menu(String country, String franchise) throws Exception {
		Locale locale = new Locale.Builder().setRegion(country).build();
		Currency currency = Currency.getInstance(locale);
		this.country = country;
		this.franchise = franchise;
		this.currencyCode = currency.getCurrencyCode();
		this.currencySymbol = currency.getSymbol(locale);

		// Fetch exchange rate using API
		this.exchangeRate = ExchangeRate.getRate(currencyCode);

		// Fetch weather using API
		this.temperature = Weather211.getCityWeather(franchise); // Assuming the franchise name is the city name
	}
	public void setPromotionText(String promotionText) {
		this.promotionText = promotionText;
	}

	public void applyDiscount(double discountRate) {
		this.discountRate = discountRate / 100.0; // Convert percentage to a decimal
	}



		public void applyTemperaturePromotion ( double currentTemperature){
			if (currentTemperature >= tooHotTemperature) {
				// Apply discount if the current temperature is greater than or equal to the 'too hot' limit
				this.discountRate += 0.0;
			}
		}

		public void setTooHotTemperature ( int tooHotTemperature){
			this.tooHotTemperature = tooHotTemperature;
		}

		@Override
		public void printMenu () {
			DecimalFormat priceFormat = new DecimalFormat("0.00");

			// Debugging: Log current values
			System.out.println("Exchange Rate: " + exchangeRate);
			System.out.println("Discount Rate: " + discountRate);
			System.out.println("Temperature: " + temperature);

			String[] names = new String[3];
			String[] prices = new String[3];
			String[] toppings = new String[3];
			int i = 0;

			for (Integer key : getBurgerMap().keySet()) {
				BurgerInfo burger = getBurgerInfo(key);
				double localPrice = burger.getPrice() * exchangeRate * (1 - discountRate);

				// Debugging: Log calculated price
				System.out.println("Price before discount for " + burger.getName() + ": " + burger.getPrice() * exchangeRate);
				System.out.println("Price after discount for " + burger.getName() + ": " + localPrice);

				names[i] = burger.getName();
				prices[i] = currencySymbol + priceFormat.format(localPrice);
				toppings[i] = burger.getTopping();

				i++;
			}

			// Call MenuGUI here with updated values
			new MenuGUI(franchise, promotionText, names[0], prices[0], toppings[0],
					names[1], prices[1], toppings[1], names[2], prices[2], toppings[2], exchangeRate, temperature);
		}
	}