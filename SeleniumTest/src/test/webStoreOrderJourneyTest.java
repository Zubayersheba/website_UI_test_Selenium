package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class webStoreOrderJourneyTest {
	WebDriver driver = null;
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
	    driver.get("https://new-smanager-webstore.dev-sheba.xyz/s/sudoku-busibes/products");
	    driver.findElement(By.xpath("//img[@alt='rice']")).click();
	    driver.findElement(By.xpath("//div[@id='__next']/main/main/div[2]/div[2]/div[2]/div[6]/button")).click();
	    driver.findElement(By.xpath("//div[@id='__next']/main/main/div[4]/div/div[2]/div[2]/div/div[3]/div[2]/button")).click();
	    driver.findElement(By.name("emailOrMobile")).sendKeys(mobile_number);
	    driver.findElement(By.id("login-password")).sendKeys(password);
	    //ERROR: Caught exception [ERROR: Unsupported command [doubleClick | id=login-password | ]]
	    driver.findElement(By.xpath("//div[@id='__next']/main/main/div[4]/div/div[2]/div[2]/div/form/div[2]/div[3]/button")).click();
	    driver.get("https://new-smanager-webstore.dev-sheba.xyz/s/sudoku-busibes/checkout");
	    // Assertions for place order button
	    Assert.assertEquals(driver.findElement(By.xpath("//div[@id='__next']/main/div/main/div[2]/div/div[2]/div[2]/div/div[2]/div[2]/div/button")).getText(), "Place Order");
	    //Assertions for customer mobile and phone number
	    Assert.assertEquals(driver.findElement(By.xpath("//div[@id='__next']/main/div/main/div[2]/div/div[2]/div/div/div/div/div/div/h3")).getText(), "zubu , 01678242967");
	    //Assertion on item price
	    Assert.assertEquals(driver.findElement(By.xpath("//div[@id='__next']/main/div/main/div[2]/div/div[2]/div/div[3]/div/div/div[2]/div/p[2]")).getText(), "৳100");
	    driver.findElement(By.xpath("//div[@id='__next']/main/div/main/div[2]/div/div[2]/div[2]/div/div[2]/div[2]/div/button")).click();
	    driver.get("https://new-smanager-webstore.dev-sheba.xyz/s/sudoku-busibes/orders/2006584/success");
	    driver.findElement(By.xpath("//div[@id='__next']/main/div/main/div[2]/div[3]/button[2]")).click();
	  }
	@AfterTest
	public void tearDownTest() {
		driver.quit();}

}
