package com.ShoppingDemo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SocialMedia {
	public static void Twitter(WebDriver driver) throws InterruptedException {
		WebElement twitterX = driver.findElement(By.xpath("//a[contains(text(), 'Twitter')]"));
		
		twitterX.click();
		Thread.sleep(2000);
		
	}
	
	public static void Facebook (WebDriver driver) throws InterruptedException {
		WebElement facebook = driver.findElement(By.xpath("//a[contains(text(), 'Facebook')]"));
		
		facebook.click();
		Thread.sleep(2000);
		
		
	}
	
	public static void LinkedIn (WebDriver driver) throws InterruptedException {
		WebElement linkedIn = driver.findElement(By.xpath("//a[contains(text(), 'LinkedIn')]"));
		
		linkedIn.click();
		Thread.sleep(2000);
		
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		
		Locate.logIn(driver);
		SocialMedia.Twitter(driver);
		
		String xTitle = driver.getTitle();
		System.out.println("Opened: " + xTitle);
		
		SocialMedia.Facebook(driver);
		String fTitle = driver.getTitle();
		System.out.println("Opened: " + fTitle);
		
		SocialMedia.LinkedIn(driver);
		String lTitle = driver.getTitle();
		System.out.println("Opened: " + lTitle);
		
		Thread.sleep(10000);
		
		driver.quit();

	}

}
