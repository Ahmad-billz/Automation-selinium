import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Program Files/chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addExtensions(new File("C://Program Files/extension_4_3_6_0.crx"));
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/"); 
		
		//Q1: check checkbox and verify, uncheck and verify
		driver.findElement(By.id("checkBoxOption1")).click();
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected()) ;
		
		driver.findElement(By.id("checkBoxOption1")).click();
		Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected()) ;		
		
		//Q2: number of checkboxes on the page
		System.out.println(driver.findElements(By.xpath("//*[@type='checkbox']")).size()+" checkboxes");
	
	
	
	
	
	}

}
