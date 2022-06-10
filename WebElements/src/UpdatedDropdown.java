import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://Program Files/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C://Program Files/extension_4_3_6_0.crx"));
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise");
		
//		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
//		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		
		//count # of checkboxes
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size() + " checkboxes");
		
		driver.findElement(By.id("divpaxinfo")).click(); //adult dropdown
		Thread.sleep(2000);
		
/*		int i = 1;
		while(i<4)
		{
			driver.findElement(By.id("hrefIncAdt")).click(); //add adult
			i++;
		}		*/
		
		for(int i=1; i<4; i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click(); //add adult
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click(); //done button
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adults");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
	}

}
