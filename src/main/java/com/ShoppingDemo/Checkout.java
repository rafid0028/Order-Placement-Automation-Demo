package com.ShoppingDemo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Checkout {
	
	public static void openCheckout (WebDriver driver) {
		WebElement openCheckout = driver.findElement(By.xpath("//button[starts-with(@id,\"checkout\")]"));
		
		openCheckout.click();
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		
		Locate.logIn(driver);
		Products.findProduct(driver);
		Buy.AddToCart(driver);
		Buy.OpenCart(driver);
		Checkout.openCheckout(driver);
		Locate.credentials(driver);
		Locate.logOut(driver);
		
		Thread.sleep(5000);
		
		driver.close();

	}

}
