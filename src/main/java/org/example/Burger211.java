package org.example;

import java.util.HashMap;
import java.util.Map;


//This abstract class represents the burger menu and will be inherited by the Menu class.
public abstract class Burger211 {
	private Map<Integer, BurgerInfo> burgerMap;
	public Burger211() {
		burgerMap = new HashMap<>();
		burgerMap.put(1, new BurgerInfo("Inheritance Burger", 4.5, "beef patty, tomato, onion, black olive, ranch sauce"));
		burgerMap.put(2, new BurgerInfo("@Override Burger", 5.5, "beef patty, lime, onion, lettuce, tomato sauce"));
		burgerMap.put(3, new BurgerInfo("Polymorphism Burger", 6.5, "chicken breast, gallo, onion, ranch sauce"));
	}


	 // Abstract method to print the menu. This will be implemented by subclasses.
	public abstract void printMenu();

	// Getters and setters
	public Map<Integer, BurgerInfo> getBurgerMap() {
		return burgerMap;
	}

	public void setBurgerMap(Map<Integer, BurgerInfo> burgerMap) {
		this.burgerMap = burgerMap;
	}

	public BurgerInfo getBurgerInfo(int burgerKey) {
		return burgerMap.get(burgerKey);
	}

	public void updateBurgerInfo(int burgerKey, BurgerInfo burgerInfo) {
		burgerMap.put(burgerKey, burgerInfo);
	}
}
