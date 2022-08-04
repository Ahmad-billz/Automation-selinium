import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {

	public static void main(String[] args) {
		
		ChromeOptions opt = new ChromeOptions();
		opt.addExtensions(new File("C://Program Files/extension_4_3_6_0.crx"));
		opt.setAcceptInsecureCerts(true);
		
		System.setProperty("webdriver.chrome.driver", "C://Program Files/chromedriver.exe");
		WebDriver driver = new ChromeDriver(opt);
		
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
		//delete all cookies
		driver.manage().deleteAllCookies();
		

		
		

	}

}
