package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPlace {
	WebDriver driver;
	public OrderPlace(WebDriver driver){

        this.driver = driver;

    }
	public void orderPlaceButtonClick() {
		driver.findElement(By.xpath("//div[@id='__next']/main/div/main/div[2]/div/div[2]/div[2]/div/div[2]/div[2]/div/button")).click();
		driver.findElement(By.xpath("//div[@id='__next']/main/div/main/div[2]/div[3]/button[2]")).click();
	}

}
