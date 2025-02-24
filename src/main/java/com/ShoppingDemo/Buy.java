package com.ShoppingDemo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Buy {
	public static void AddToCart(WebDriver driver) {
		WebElement addToCart = driver.findElement(By.xpath("//button[starts-with(@name,\"add\")]"));
		
		addToCart.click();
	}
	
	public static void OpenCart(WebDriver driver) {
		WebElement openCart = driver.findElement(By.xpath("//a[starts-with(@class,\"shopping_cart_link\")]"));
		
		openCart.click();
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		
		Locate.logIn(driver);
		Products.findProduct(driver);
		Buy.AddToCart(driver);
		Locate.backToAllProducts(driver);
		Buy.OpenCart(driver);
		
		Thread.sleep(5000);
		
		driver.close();

	}

}
