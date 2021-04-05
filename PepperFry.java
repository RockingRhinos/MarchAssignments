package marAssignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PepperFry {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions builder = new Actions(driver);		
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("one plus 7 pro mobiles", Keys.ENTER);
		
		WebElement firstPrice = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
		System.out.println(firstPrice.getText());
		
		WebElement firstResult = driver.findElement(By.xpath("((//div[@class='a-section a-spacing-none'])//img)[1]"));
		firstResult.click();
		
		Set<String> winSet = driver.getWindowHandles();
		List<String> winLis = new ArrayList<String>(winSet);
		driver.switchTo().window(winLis.get(1));
		
		WebElement ratings = driver.findElement(By.xpath("(//span[@id='acrCustomerReviewText'])[1]"));
		System.out.println(ratings.getText());
		
		driver.findElement(By.id("add-to-cart-button")).click();
		
		boolean displayed = driver.findElement(By.xpath("(//h4[text()='Added to Cart'])[2]")).isDisplayed();
		
		if (displayed) {
			System.out.println("Verification successful");
		}
		
		driver.findElement(By.xpath("//span[@id='attach-sidesheet-checkout-button']/span[1]/input[1]")).click();
		
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		boolean errorMsg = driver.findElement(By.xpath("//div[contains(text(),'Enter your email or mobile phone number')]")).isDisplayed();
		
		if (errorMsg) {
			System.out.println("TC successful");
		}
		
		driver.close();
		
	}

}
