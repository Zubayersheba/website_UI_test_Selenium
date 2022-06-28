package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class addToCartTest {
	WebDriver driver = null;
	String pageTitle;
	String expectedTitle = "Daraz.com.bd: Online Shopping Bangladesh - Mobiles, Tablets, Home Appliances, TV, Audio &amp; More";
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver_linux64/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://member.daraz.com.bd/user/login?spm=a2a0e.home.header.d5.735212f7tfMK0w&redirect=https%3A%2F%2Fwww.daraz.com.bd%2F");
	    driver.findElement(By.xpath("//div[@id='container']/div/div[2]/form/div/div/div/input")).sendKeys("01678242967");
	   
	    driver.findElement(By.xpath("//div[@id='container']/div/div[2]/form/div/div/div[2]/input")).sendKeys("zubayersheba18");
	    
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	
    
    
	
	@Test
	public void afterLoginaddToCart() {
		driver.get("https://www.daraz.com.bd/");
	    driver.findElement(By.xpath("//img[@alt='1pcs Artificial Leather Analog Watch for Men - Black']")).click();
	    //driver.findElement(By.xpath("//div[@id='hp-flash-sale']/div[2]/div[2]/a/div[2]/div")).click();
	    driver.findElement(By.xpath("//div[@id='module_add_to_cart']/div/button[2]/span/span")).click();
	    driver.findElement(By.xpath("//div[@id='dialog-body-1']/div/div/div/div[2]/div/div[2]/div/div[2]/button[2]")).click();Assert.assertEquals(driver.findElement(By.id("automation-link-from-title-to-prod-item_i174e1fe41")).getText(), "1pcs Artificial Leather Analog Watch for Men - Black");
	    }
	
	@AfterTest
	public void tearDownTest() {
		//driver.quit();
		
		
		
	}
	

}
