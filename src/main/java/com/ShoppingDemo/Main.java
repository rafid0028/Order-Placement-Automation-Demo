package com.ShoppingDemo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		
		//Login with credentials
		Locate.logIn(driver);
		Thread.sleep(2000);
		
		//Add a product to the cart
		Products.findProduct(driver);
		Thread.sleep(2000);
		
		Buy.AddToCart(driver);
		Thread.sleep(2000);
		
		//BackToALlProducts
		Locate.backToProducts(driver);
		Thread.sleep(2000);
		
		//Opens the cart to check
		Buy.OpenCart(driver);
		Thread.sleep(2000);
		
		//Decided to go back add more products
		Locate.continueShopping(driver);
		Thread.sleep(1000);
		
		//Add to cart directly from inventory
		Buy.AddToCart(driver);
		Buy.OpenCart(driver);
		Thread.sleep(2000);
		
		//Decided to remove an item
		Locate.removeItem(driver);
		Thread.sleep(1500);
		
		//Proceed to checkout with providing credentials
		Checkout.openCheckout(driver);
		Thread.sleep(1000);
		
		Locate.credentials(driver);
		Thread.sleep(2000);
		
		//Logout
		Locate.logOut(driver);
		Thread.sleep(2000);
		
		driver.close();

	}

}
