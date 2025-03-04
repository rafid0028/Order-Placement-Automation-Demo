package com.ShoppingDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG {
   WebDriver driver;
   
   @BeforeClass
   
   public void setup() {
	   WebDriverManager.chromedriver().setup();
	   driver = new ChromeDriver();
	   driver.manage().deleteAllCookies();
	   driver.manage().window().maximize();
	   driver.get("https://www.saucedemo.com/");
	   
   }
   
   @Test (priority = 1)
   public void verifyPageTitle() {
	   String actualTitle = driver.getTitle();
	   String expectedTitle = "Swag Labs";
	   System.out.println("The Page Title is: " + actualTitle);
	   
	   Assert.assertEquals(actualTitle, expectedTitle);
   }
   
   @Test (priority = 2)
   //Username and Password can take inputs
   public void verifyTakingInputs() throws InterruptedException {
	   	WebElement usernameField = driver.findElement(By.xpath("//input[@id=\"user-name\"]"));
	   	WebElement passField = driver.findElement(By.xpath("//input[@id=\"password\"]"));
		   
	   	Assert.assertTrue(usernameField.isDisplayed(), "Username Input Field is not visible");
	   	Assert.assertTrue(passField.isDisplayed(), "Password Input Field is not visible");
	   	usernameField.sendKeys("standard_user");
	   	Thread.sleep(1000);
	   	
	   	Assert.assertEquals(usernameField.getAttribute("value"), "standard_user");
	   	Thread.sleep(1000);
	   	usernameField.clear();
	   	Thread.sleep(1000);
   }
   
   @Test (priority = 3)
   public void verifyInvalidDataInputs() throws InterruptedException {
	   	WebElement usernameField = driver.findElement(By.xpath("//input[@id=\"user-name\"]"));
	   	WebElement passField = driver.findElement(By.xpath("//input[@id=\"password\"]"));
	   	SoftAssert softAssert3 = new SoftAssert();
		softAssert3.assertTrue(usernameField.isDisplayed(), "Username Input Field is not visible");
	   	SoftAssert softAssert2 = new SoftAssert();
		softAssert2.assertTrue(passField.isDisplayed(), "Password Input Field is not visible");
	   	usernameField.sendKeys("bla_ba");
	   	Thread.sleep(1000);
	   	passField.sendKeys("1213@#_");
	   	WebElement loginButton = driver.findElement(By.xpath("//input[@id=\"login-button\"]"));
	   	loginButton.click();
	   	
	   	WebElement errorLogin = driver.findElement(By.xpath("//h3[@data-test=\"error\"]"));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(errorLogin.isDisplayed(), "Logged In");		  	
		usernameField.clear();
	   	Thread.sleep(1000);
	   	
	   	softAssert.assertAll();
	   	
   }
   
   @Test (priority = 4)
   //Login with credentials
   public void verifyLogin() throws InterruptedException {
	   	
	   	driver.get("https://www.saucedemo.com/");	   
	   	Locate.logIn(driver);
		Thread.sleep(1500);
		
		WebElement filterButton = driver.findElement(By.xpath("//select[@class=\"product_sort_container\"]"));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(filterButton.isDisplayed(), "HomePage Unique_Filter Button Not Displayed, Login Failed");
		
		softAssert.assertAll();
   }
   
   @Test (priority = 5)
 	//Add a product to the cart
   public void addToCartfromProductDetails() throws InterruptedException {
	   
	   Products.findProduct(driver);
	   Thread.sleep(1500);
		
	   Buy.AddToCart(driver);
	   Thread.sleep(1500);
	   WebElement productDetails = driver.findElement(By.xpath("//div[@class=\"inventory_details_desc large_size\"]"));
	   Assert.assertTrue(productDetails.isDisplayed(), "Product Details isn't visible");
		
   }
   
   @Test (priority = 6)
   //BackToALlProducts 
   public void verifyClickBackToProducts() throws InterruptedException{
	   
	   WebElement backButton = driver.findElement(By.xpath("//button[@id=\"back-to-products\"]"));
	   Assert.assertTrue(backButton.isDisplayed(), "Back Button Is Not Displayed");
		
	   Locate.backToProducts(driver);
	   Thread.sleep(1500);
		
   }
   
   @Test (priority = 7)
   //Opens the cart to check
   public void verifyOpenCart() throws InterruptedException{
	   
	   Buy.OpenCart(driver);
	   Thread.sleep(1500);
	   
	   WebElement confirmCart = driver.findElement(By.xpath("//span[@class=\"title\"]")); 
	   
	   Assert.assertTrue(confirmCart.isDisplayed(), "Your Cart is not Displayed, Cart is not Open");
		
   }
   
   @Test (priority = 8)
   //Decided to go back add more products
   public void verifyGoingBackToInventory() throws InterruptedException{
	   	Locate.continueShopping(driver);
		Thread.sleep(1500);
		
		//Goes Back to inventory page by clicking continue shopping button. Verify by following code.
		
		WebElement filterButton = driver.findElement(By.xpath("//select[@class=\"product_sort_container\"]"));
		Assert.assertTrue(filterButton.isDisplayed(), "HomePage Unique_Filter Button Not Displayed, Login Failed");
		
		//Adds more products to the cart		
		Buy.AddToCart(driver);
		Thread.sleep(1500);
		
   }
   
   @Test (priority = 9)
   //Add to cart directly from inventory
   public void verifyAddingToCartFromInventory() throws InterruptedException{
	   	Buy.AddToCart(driver);
		Buy.OpenCart(driver);
		Thread.sleep(1500);
		
		//Opens Cart and verifies by following code
		WebElement confirmCart = driver.findElement(By.xpath("//span[@class=\"title\"]")); 
		  
		Assert.assertTrue(confirmCart.isDisplayed(), "Your Cart is not Displayed, Cart is not Open");
				
		
   }
   
   @Test (priority = 10)
   //Decided to remove an item
   public void verifyRemovingItemFromCart() throws InterruptedException{
	   	Locate.removeItem(driver);
		Thread.sleep(1500);
		
		WebElement removeButton = driver.findElement(By.xpath("//button[contains(text(), 'Remove')]"));
		
		Assert.assertTrue(removeButton.isDisplayed(), "Remove Button is not Visible");
		
   }
   
   @Test (priority = 11)
   //Proceed to checkout with providing credentials
   public void verifyInsertingAddress() throws InterruptedException{
	   	Checkout.openCheckout(driver);
		Thread.sleep(1500);
		
		//Verifies opening address sections
		WebElement yourInformation = driver.findElement(By.xpath("//span[contains(text(), 'Information')]"));
		Assert.assertTrue(yourInformation.isDisplayed(), "Your Information Page is not visible");
		Locate.credentials(driver);
		Thread.sleep(1500);
		
   }
   
   @Test (priority = 12)
   public void socialMedia() {
	   WebElement twitterX = driver.findElement(By.xpath("//a[contains(text(), 'Twitter')]"));
	   Assert.assertTrue(twitterX.isDisplayed(), "Twitter Icon is not visible");
	   twitterX.click();
	   
	   
	   WebElement facebook = driver.findElement(By.xpath("//a[contains(text(), 'Facebook')]"));
	   Assert.assertTrue(facebook.isDisplayed(), "Facebook Icon is not visible");
	   facebook.click();
	   
	   
	   WebElement linkedIn = driver.findElement(By.xpath("//a[contains(text(), 'LinkedIn')]"));
	   Assert.assertTrue(linkedIn.isDisplayed(), "LinkedIn Icon is not visible");
	   linkedIn.click();
	   
   }
   
   @Test (priority = 13)
   //Logout
   public void verifyLogout() throws InterruptedException{
	   Locate.logOut(driver);
	   Thread.sleep(1500);
		
	   WebElement loginButton = driver.findElement(By.xpath("//input[@id=\"login-button\"]"));
	   Assert.assertTrue(loginButton.isDisplayed(), "Login Button is not visible");
   }
 		

   
   @AfterClass
   
   public void tearDown() {
	   driver.quit();
   }


}
