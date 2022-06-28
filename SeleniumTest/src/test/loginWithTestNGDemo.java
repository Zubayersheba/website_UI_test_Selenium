package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class loginWithTestNGDemo {
	WebDriver driver = null;
	String pageTitle;
	String expectedTitle = "Daraz.com.bd: Online Shopping Bangladesh - Mobiles, Tablets, Home Appliances, TV, Audio &amp; More";
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver_linux64/chromedriver");
		driver = new ChromeDriver();
	}
	@Test
	public void logInDarazAccount() {
		
		driver.get("https://member.daraz.com.bd/user/login?spm=a2a0e.home.header.d5.735212f7tfMK0w&redirect=https%3A%2F%2Fwww.daraz.com.bd%2F");
	    driver.findElement(By.xpath("//div[@id='container']/div/div[2]/form/div/div/div/input")).sendKeys("01678242967");
	   
	    driver.findElement(By.xpath("//div[@id='container']/div/div[2]/form/div/div/div[2]/input")).sendKeys("zubayersheba18");
	    
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    pageTitle=driver.getTitle();
	    Assert.assertEquals(pageTitle,expectedTitle);
	    	    
	}
	@Test
	@AfterTest
	public void tearDownTest() {
		driver.quit();
		
		
		
	}

}
