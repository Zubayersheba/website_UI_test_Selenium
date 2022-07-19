package pom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddtoCartElements {
	
	public WebDriver driver;
	public AddtoCartElements(WebDriver driver){

        this.driver = driver;

    }
	
	public void getProduct() {
		
		driver.get("https://new-smanager-webstore.dev-sheba.xyz/s/sudoku-busibes/products");
	}
	public void clickProduct() {
		driver.findElement(By.xpath("//img[@alt='rice']")).click();
	}
	public void addtoCartButtonClick() {
		driver.findElement(By.xpath("//div[@id='__next']/main/main/div[2]/div[2]/div[2]/div[6]/button")).click();
	}
	public void checkoutButtonClick() {
		driver.findElement(By.xpath("//div[@id='__next']/main/main/div[4]/div/div[2]/div[2]/div/div[3]/div[2]/button")).click();
	}

}
