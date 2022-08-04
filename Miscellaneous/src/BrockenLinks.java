import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;

public class BrockenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		ChromeOptions opt = new ChromeOptions();
		opt.addExtensions(new File("C://Program Files/extension_4_3_6_0.crx"));
		opt.setAcceptInsecureCerts(true);
		
		System.setProperty("webdriver.chrome.driver", "C://Program Files/chromedriver.exe");
		WebDriver driver = new ChromeDriver(opt);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> links = driver.findElements(By.cssSelector("li[class=gf-li] a"));
		SoftAssert softA = new SoftAssert();
		for(WebElement link: links) {
			String url = link.getAttribute("href")	;	
		
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		    conn.setRequestMethod("HEAD");
		    conn.connect();
		    int respCode = conn.getResponseCode();
		    softA.assertTrue(respCode<400, "The link with Test \'"+ link.getText()+"\' is broken with code "+respCode);
		   
		}
		softA.assertAll();

	}

}
