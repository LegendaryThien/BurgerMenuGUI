The program is designed for you to pick a country
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
