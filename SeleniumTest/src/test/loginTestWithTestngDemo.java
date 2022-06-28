package test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class loginTestWithTestngDemo {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private JavascriptExecutor js;

  @BeforeClass
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "chromedriver_linux64/chromedriver");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testLogin() throws Exception {
	  driver.get("https://member.daraz.com.bd/user/login?spm=a2a0e.home.header.d5.735212f7tfMK0w&redirect=https%3A%2F%2Fwww.daraz.com.bd%2F");
	    driver.findElement(By.xpath("//div[@id='container']/div/div[2]/form/div/div/div/input")).sendKeys("01678242967");
	   
	    driver.findElement(By.xpath("//div[@id='container']/div/div[2]/form/div/div/div[2]/input")).sendKeys("zubayersheba18");
	    
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
  }

  @AfterClass
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}

