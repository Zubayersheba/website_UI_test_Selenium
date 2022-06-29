package test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

//**Test case : Tried to login with invalid user name and password
//**Expected result : user will be unable to login and message will be appeared "User Not Found"


public class loginFailed {
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
	 public void testUntitledTestCase() {
	    driver.get("https://new-smanager-webstore.dev-sheba.xyz/s/sudoku-busibes");
	    driver.findElement(By.xpath("//img[@alt='profile-pic']")).click();
	    driver.findElement(By.name("emailOrMobile")).sendKeys("01755889856");
	    driver.findElement(By.id("login-password")).sendKeys("159632");
	    driver.findElement(By.xpath("//div[@id='__next']/main/div/main/div[2]/div/form/div[2]/div[3]/button")).click();
	    Assert.assertEquals(driver.findElement(By.xpath("//div[@id='__next']/main/div/main/div[2]/div/form/div[2]/div/div/p")).getText(), "User Not Found");
	  }
	@AfterTest
	public void tearDownTest() {
		driver.quit();}

}
