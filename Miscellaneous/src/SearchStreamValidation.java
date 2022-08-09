import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class SearchStreamValidation {

	public static void main(String[] args) {
		ChromeOptions opt = new ChromeOptions();
		opt.addExtensions(new File("C://Program Files/extension_4_3_6_0.crx"));
		System.setProperty("webdriver.chrome.driver", "C://Program Files/chromedriver.exe");
		WebDriver driver = new ChromeDriver(opt);	
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]")); //results from search
		
		List<WebElement> filteredList = veggies.stream().filter(veggie->veggie.getText().contains("Rice")).
				collect(Collectors.toList());   //to check if it really contains the searched keys
		
		Assert.assertEquals(veggies.size(), filteredList.size());  //if the size matches, the search button is working fine
		
		
	}

}
