import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Sellintroduction {

	public static void main(String[] args) {
		
		//Invoking Browser
		// Chrome - ChromeDriver ->Methods	
		System.setProperty("webdriver.chrome.driver", "C://Program Files/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Microsoft Edge
		System.setProperty("webdriver.edge.driver", "C://Program Files/msedgedriver.exe");
		WebDriver driver2 = new EdgeDriver();
		
		//Firefox
		System.setProperty("webdriver.gecko.driver", "C://Program Files/geckodriver.exe");
		WebDriver driver3 = new FirefoxDriver();
		
		driver.get("https://www.youtube.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.quit();		
		
	}

}
