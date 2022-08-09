import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class StreamsJava {

	public static void main(String[] args) {
		ChromeOptions opt = new ChromeOptions();
		opt.addExtensions(new File("C://Program Files/extension_4_3_6_0.crx"));
		
		System.setProperty("webdriver.chrome.driver", "C://Program Files/chromedriver.exe");
		WebDriver driver = new ChromeDriver(opt);
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//click on column to sort them
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//capture all webElements into a list
		List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
		
		//capture text of all WebElements into new (original) list
		List<String> originalList = elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//sort originalList with Stream()
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		
		//Compare originalList vs sortedList
		Assert.assertTrue(originalList.equals(sortedList));
		
		//CUSTOM METHOD with stream and PAGINATION 
		//print price of Beans from the table
		List<String> price;
		do {
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			price= rows.stream().filter(s->s.getText().contains("Rice")).
				map(s->getPriceVeggie(s)).collect(Collectors.toList());
			price.forEach(a->System.out.println(a));			
			if(price.size()<1) driver.findElement(By.cssSelector("[aria-label='Next']")).click();
		}while(price.size()<1);
	}
	private static String getPriceVeggie(WebElement s) {
		String priveValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priveValue;
	}
	
	
	
	
	
	
	
	
	

}
