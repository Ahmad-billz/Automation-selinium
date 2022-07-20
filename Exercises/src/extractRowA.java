import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class extractRowA {

	public static void main(String[] args) throws InterruptedException {


		System.setProperty("webdriver.chrome.driver","C://Program Files/chromedriver.exe");					 
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		//number of rows
		List<WebElement> nRows =driver.findElements(By.cssSelector("div[class=\"left-align\"] table[id=\"product\"] tr"));
		System.out.println("Number of rows: "+nRows.size());
		//number of cols
		List<WebElement> nCols =driver.findElements(By.cssSelector("div[class='left-align'] table[id='product'] tr:nth-child(1) th"));
		System.out.println("Number of columns: "+nCols.size());
		//extract a row
		List<WebElement> thirdRow = driver.findElements(By.cssSelector("div[class='left-align'] table[id='product'] tr:nth-child(3) td"));
		for (int i = 0; i < thirdRow.size();i++) {
			System.out.println(thirdRow.get(i).getText());
		}
		
		driver.findElement(By.id("autocomplete")).sendKeys("uni");
		Thread.sleep(2000);
	    driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
	    driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
	    
	    System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value")); 
		
		
	}
}
