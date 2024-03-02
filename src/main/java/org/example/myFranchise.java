package org.example;

import java.util.Scanner;

/*
Name: Anh-Thien Nguyen
ID: 202660307
Date: 2/9/24

Program Description: The program is designed for you to pick a country
and a city that the franchise may be located in and decide on a promotion
discount based on how hot it is in a certain location, and you can decide what
degree in Fahrenheit that you want to make it so that if it exceeds the degree then
the discount applies. Then after that, you can decide on the ingredients for
Inheritance Burger, @override burger, and Polymorphism burger. After all that,
a Menu GUI is created with your promotional text, discounts applied, and the ingredients
you chose! This allows you to easily customize your menu for each franchise in any
country and city.

This program utilizes API to access data from an exchange rate website and a weather website.
The exchange rate website is used to convert currencies based on a chosen country alpha code.
The weather app determines weather discount for certain cities. Both APIs access Menu.java which is
the core subclass that accesses the APIs, the GUI, the Test Program, AND the information for the burger.
Burger211 is the core information for the burger and it is the superclass of Menu.java. Burgerinfo is
the core information for a singular burger and Burger211 is the only class hat accesses Burgerinfo directly.
Lastly, Menu.java goes into myFranchise.java which is the test program to use.

 */

public class myFranchise {
		public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
			String country;
			String franchiseName;
			double discount;
			int tooHot;
			double currentTemperature;
			Menu franchiseMenu;

			System.out.println("Welcome to Burger211 franchise management system!");

			// Get country code and franchise name
			System.out.println(" ");
			System.out.print("Enter country code (Alpha-2 code): ");
			country = input.nextLine();

			System.out.println(" ");
			System.out.print("Enter your city name: ");
			franchiseName = input.nextLine();

			// Instantiate a Menu for the franchise
			try {
				franchiseMenu = new Menu(country, franchiseName);

				// Fetch current temperature
				currentTemperature = Weather211.getCityWeather(franchiseName);
			} catch (Exception e) {
				System.out.println("Error setting up the menu: " + e.getMessage());
				input.close();
				return;
			}

			// Prompt for the promotion message
			System.out.println(" ");
			System.out.println("Enter the promotion. If there is no promotion, press Enter.");
			String promotionText = input.nextLine();

			// Check if the promotion text is empty and provide a default message if necessary
			if (promotionText.isEmpty()) {
				promotionText = "No promotion today";
			}

			franchiseMenu.setPromotionText(promotionText);
			boolean validInput = false;
			while (!validInput) {
				try {
					System.out.println(" ");
					System.out.print("Enter the promotion discount rate (%): ");
					discount = Double.parseDouble(input.nextLine());
					franchiseMenu.applyDiscount(discount);
					validInput = true;  // Will be reached only if parsing succeeds
				} catch (NumberFormatException e) {
					System.out.println("Please enter a valid numeric value for the discount rate.");
				}
			}


			// Check for temperature based promotions
			System.out.println(" ");
			System.out.print("Enter a temperature for 'too hot to eat' promotion: ");
			tooHot = Integer.parseInt(input.nextLine());
			franchiseMenu.setTooHotTemperature(tooHot);
			franchiseMenu.applyTemperaturePromotion(currentTemperature);


			// Ask the user which burger they would like to change the toppings for
			System.out.println(" ");
			System.out.println("Which burger would you like to change the topping? (enter 0 if not)");
			System.out.println("Inheritance Burger: beef patty, tomato, onion, black olive, ranch");
			System.out.println("@Override Burger: beef patty, lime, onion, lettuce, tomato source");
			System.out.println("Polymorphism Burger: chicken breast, gallo, onion, ranch source");

			int burgerChoice = Integer.parseInt(input.nextLine());

			if (burgerChoice != 0) {
				BurgerInfo burgerToUpdate = franchiseMenu.getBurgerInfo(burgerChoice);
				System.out.println("Current toppings for " + burgerToUpdate.getName() + ": " + burgerToUpdate.getTopping());
				System.out.println("Enter new toppings of " + burgerToUpdate.getName());
				String newToppings = input.nextLine();

				// Update the toppings in the Menu
				burgerToUpdate.setTopping(newToppings);
				franchiseMenu.updateBurgerInfo(burgerChoice, burgerToUpdate);

			}
			franchiseMenu.printMenu();
			input.close();
		}
	}

