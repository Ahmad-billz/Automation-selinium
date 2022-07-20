import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class siteBug {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://Program Files/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));   //Explicit wait
		driver.get("https://www.eximia-engineering.de/");	
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("comp-kmkj353m1label")));
		driver.findElement(By.id("comp-kmkj353m1label")).click();
		Thread.sleep(3000);
		
		List<WebElement> names = driver.findElements(By.cssSelector(".color_18"));
		List<String> namesAll = new ArrayList<>();
		
		for (int i = 0; i < names.size(); i++) {
			String rawName = names.get(i).getText();
			namesAll.add(rawName);

		 for (int i1 = 0; i1 < namesAll.size(); i1++) {
		     for (int j = i1 + 1 ; j < namesAll.size(); j++) {
		          if (namesAll.get(i1).equals(namesAll.get(j))) {
		                   System.out.println(i1+" is present more than once");
		          }
		     }
		 }
	}
	}
}
