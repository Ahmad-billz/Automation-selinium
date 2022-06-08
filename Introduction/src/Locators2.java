import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://Program Files/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("C://Program Files/extension_4_3_6_0.crx"));
		WebDriver driver = new ChromeDriver(options);
		
		//System.setProperty("webdriver.edge.driver", "C://Program Files/msedgedriver.exe");
		//WebDriver driver = new EdgeDriver();
		
		String name="Ahmad";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String password = getPassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice");
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(password);	
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello "+name+",");
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		//driver.close();
	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div[class='forgot-pwd-btn-conainer'] button:nth-child(2)")).click();
		String passPhrase = driver.findElement(By.cssSelector("form p")).getText();
		String [] passArray = passPhrase.split("'");
		String password = passArray[1].split("'")[0];
		return password;	
		
	}
	
	
}
