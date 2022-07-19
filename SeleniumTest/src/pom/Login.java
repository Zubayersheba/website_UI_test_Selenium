package pom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	WebDriver driver;
	public Login(WebDriver driver){

        this.driver = driver;

    }
	
	public void getMobileNumber(String mobile_number) {
		driver.findElement(By.name("emailOrMobile")).sendKeys(mobile_number);
	}
	public void getPassword(String password) {
		driver.findElement(By.id("login-password")).sendKeys(password);
	}
	public void clickLoginButton() {
		driver.findElement(By.xpath("//div[@id='__next']/main/main/div[4]/div/div[2]/div[2]/div/form/div[2]/div[3]/button")).click();
	}

}
