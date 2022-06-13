import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GenericProducts {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://Program Files/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot" };
		int j = 0;
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		List<WebElement> buttons = driver.findElements(By.xpath("//div[@class='product-action']/button"));

		for (int i = 0; i < products.size(); i++) {
			String[] rawName = products.get(i).getText().split("-");
			String name = rawName[0].trim();
			// if the extracted name is in our itemsNeeded array
			// converting array into array list for easy searching
			List itemsNeededList = Arrays.asList(itemsNeeded);
			if(itemsNeededList.contains(name)) {
				j++;
				//driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				buttons.get(i).click();
				
				Thread.sleep(2000);
				if (j==itemsNeeded.length)
						break;
			}

		}

	}

}
