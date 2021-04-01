package marAssignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWaits {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
//		driver.get("http://leafground.com/pages/TextChange.html");
//		driver.get("http://www.leafground.com/pages/disapper.html");
		driver.get("http://www.leafground.com/pages/appear.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

/*		Assignment # 1	
 
 		WebElement clickMeButton = driver.findElement(By.xpath("//button[text()='Click ME!']"));
		wait.until(ExpectedConditions.textToBePresentInElement(clickMeButton, "Click ME!"));
		clickMeButton.click();
		
//		Assignment # 2
		
		WebElement dissappearingButton = driver.findElement(By.xpath("//button[@id='btn']//b[1]"));
		wait.until(ExpectedConditions.invisibilityOf(dissappearingButton));
		WebElement text = driver.findElement(By.tagName("strong"));
		System.out.println(text.getText());	
*/		
		
//		Assignment # 3
		
		WebElement voila = driver.findElement(By.xpath("//button[@id='btn']//b[1]"));
		String voilaText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='btn']//b[1]"))).getText();
		System.out.println(voilaText);
		
		driver.close();
		
	}

}
