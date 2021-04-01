package marAssignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Erail {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("chkSelectDateOnly")).click();
		
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("MAS", Keys.TAB);
		
		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("SBC", Keys.ENTER);
		
//		Assignment #2: ErailSorting
		
		List<WebElement> tableRows = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr"));
		List<String> trainNames = new ArrayList<String>();
		for (int i = 1; i < tableRows.size(); i++) {
			List<WebElement> allTrains = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr["+i+"]/td[2]"));
			for (WebElement eachTrain : allTrains) {
				String eachTrainName = eachTrain.getText();
				trainNames.add(eachTrainName);
			}
		}
		
		Collections.sort(trainNames);
		System.out.println();
		System.err.println("Sorted Train Names");
		for (String sortedNames : trainNames) {
			System.out.println(sortedNames);			
		}
		System.err.println("*****************************");
//		Assignment #3: Unique Trains
		
		Set<String> uniqueNames = new LinkedHashSet<String>(trainNames);
		System.err.println("Unique Train Names");
		for (String unique : uniqueNames) {
			System.out.println(unique);
		}
		
		driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
