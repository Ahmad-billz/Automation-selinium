import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowsActivities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Program Files/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("C://Program Files/extension_4_3_6_0.crx"));
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.get("https://google.com");
		
		driver.navigate().to("http:/rahulshettyacademy.com");
		driver.navigate().back();
		driver.navigate().forward();

	}

}
