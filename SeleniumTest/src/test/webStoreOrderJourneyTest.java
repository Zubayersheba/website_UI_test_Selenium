package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pom.AddtoCartElements;
import pom.Login;
import pom.OrderPlace;
//**Test case : Add to cart a product and place an order with login
//**Expected result : user will be unable choose a product and able to add to cart the product, then user will be logged in and place an order"
public class webStoreOrderJourneyTest {
	WebDriver driver;
	private JavascriptExecutor js;
	String mobile_number = "01678242967";
	String password ="123456";
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver_linux64/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    js = (JavascriptExecutor) driver;
	}
	@Test
	  public void testWebstoreAddtocart() {
		AddtoCartElements addtoCart=new AddtoCartElements(driver);
		Login login=new Login(driver);
		OrderPlace orderPlace=new OrderPlace(driver);
		// Add to cart a product
		addtoCart.getProduct();
		addtoCart.clickProduct();
		addtoCart.addtoCartButtonClick();
		addtoCart.checkoutButtonClick();
		
		//Login before add checkout
		
		login.getMobileNumber(mobile_number);
		login.getPassword(password);
		login.clickLoginButton();
		
	    driver.get("https://new-smanager-webstore.dev-sheba.xyz/s/sudoku-busibes/checkout");
	    // Assertions for place order button
	    Assert.assertEquals(driver.findElement(By.xpath("//div[@id='__next']/main/div/main/div[2]/div/div[2]/div[2]/div/div[2]/div[2]/div/button")).getText(), "Place Order");
	    //Assertions for customer mobile and phone number
	    Assert.assertEquals(driver.findElement(By.xpath("//div[@id='__next']/main/div/main/div[2]/div/div[2]/div/div/div/div/div/div/h3")).getText(), "zubu , 01678242967");
	    //Assertion on item price
	    Assert.assertEquals(driver.findElement(By.xpath("//div[@id='__next']/main/div/main/div[2]/div/div[2]/div/div[3]/div/div/div[2]/div/p[2]")).getText(), "৳100");
	    
	    //Order place button click
	    
	    orderPlace.orderPlaceButtonClick();
	    //driver.findElement(By.xpath("//div[@id='__next']/main/div/main/div[2]/div/div[2]/div[2]/div/div[2]/div[2]/div/button")).click();
	    driver.get("https://new-smanager-webstore.dev-sheba.xyz/s/sudoku-busibes/orders/2006584/success");
	  }
	@AfterTest
	public void tearDownTest() {
		driver.quit();}

}
