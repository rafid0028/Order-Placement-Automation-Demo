package com.ShoppingDemo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Products {

	
	public static void findProduct(WebDriver driver) {
		WebElement findProduct1 = driver.findElement(By.partialLinkText("Backpack"));
		
		findProduct1.click();
				
	}
	


	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		
		//Locator.logIn(driver);
		Locate.logIn(driver);
		
		Products.findProduct(driver);
		
		Buy.AddToCart(driver);
		
		Locate.backToAllProducts(driver);
			
		Thread.sleep(5000);
		
		driver.close();

	}

}
