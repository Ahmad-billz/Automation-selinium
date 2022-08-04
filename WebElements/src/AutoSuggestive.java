import java.io.File;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AutoSuggestive {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://Program Files/chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addExtensions(new File("C://Program Files/extension_4_3_6_0.crx"));
		
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("http://rahulshettyacademy.com/dropdownsPractise"); 
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(3000);
		List <WebElement> countries=driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		
		Thread.sleep(3000);
		for (WebElement country :countries ) {
			if(country.getText().equalsIgnoreCase("India"))
			{	country.click();	
				break;
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
