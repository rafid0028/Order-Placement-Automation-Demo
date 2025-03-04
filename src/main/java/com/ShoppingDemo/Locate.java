package com.ShoppingDemo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Locate {
	
	public static void logIn(WebDriver driver) {
		WebElement usernameField = driver.findElement(By.xpath("//input[@name=\"user-name\"]"));
		WebElement passwordField = driver.findElement(By.xpath("//input[@name=\"password\"]"));
		WebElement loginButton = driver.findElement(By.xpath("//input[@name=\"login-button\"]"));
		
		usernameField.clear();
		usernameField.sendKeys("standard_user");
		passwordField.sendKeys("secret_sauce");
		loginButton.click();
	}
	
	public static void backToAllProducts (WebDriver driver) {
		WebElement burgerButton = driver.findElement(By.xpath("//button[starts-with(@id, 'react')]"));
		burgerButton.click();
		WebElement allItems = driver.findElement(By.xpath("//a[@class=\"bm-item menu-item\"]"));
		allItems.click();
	}
	
	public static void backToProducts (WebDriver driver) {
		WebElement backTo = driver.findElement(By.xpath("//button[@name=\"back-to-products\"]"));
		backTo.click();
	}
	
	public static void removeItem (WebDriver driver) {
		WebElement removeItem = driver.findElement(By.xpath("//button[starts-with(@name,\"remove\")]"));
		removeItem.click();
	}
	
	public static void continueShopping (WebDriver driver) {
		WebElement newItemadd = driver.findElement(By.xpath("//button[starts-with(@name,\"continue\")]"));
		newItemadd.click();
	}
	
	public static void credentials(WebDriver driver) throws InterruptedException {
		WebElement firstName = driver.findElement(By.xpath("//input[contains(@name,\"firstName\")]"));
		firstName.sendKeys("Janina");
		Thread.sleep(1000);
		
		WebElement lastName = driver.findElement(By.xpath("//input[contains(@name,\"lastName\")]"));
		lastName.sendKeys("VuleGesi");
		Thread.sleep(1000);
		
		WebElement zipCode = driver.findElement(By.xpath("//input[contains(@name,\"postalCode\")]"));
		zipCode.sendKeys("999");
		Thread.sleep(1000);
		
		WebElement contiNue = driver.findElement(By.xpath("//input[contains(@name,\"continue\")]"));
		contiNue.click();
		Thread.sleep(1000);
		
		WebElement finish = driver.findElement(By.xpath("//button[contains(@name, \"finish\")]"));
		finish.click();
		Thread.sleep(1000);
		
		WebElement home = driver.findElement(By.xpath("//button[contains(@name, \"back-to-products\")]"));
		home.click();
		Thread.sleep(1000);

	}
	
	public static void logOut (WebDriver driver) throws InterruptedException {
		WebElement burgerButton = driver.findElement(By.xpath("//button[starts-with(@id, 'react')]"));
		burgerButton.click();
		
		Thread.sleep(1000);
		
		WebElement logOut = driver.findElement(By.xpath("//a[text()=\"Logout\"]"));
		logOut.click();
		
		
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		
		Locate.logIn(driver);
		
		Products.findProduct(driver);
		Thread.sleep(2000);
		Locate.backToProducts(driver);
		Thread.sleep(2000);
		//Locate.backToAllProducts(driver);
		//Buy.AddToCart(driver);
		//Buy.OpenCart(driver);
		//Locate.removeItem(driver);
		
		//Locate.continueShopping(driver);
		
		//Locate.logOut(driver);
		
		
				
		Thread.sleep(5000);
		
		driver.close();

	}

}
