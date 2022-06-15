import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericProducts {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://Program Files/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		/* driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//implicit wait */
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));   //Explicit wait

		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot" }; 
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);
		addItems(driver,itemsNeeded);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
	}
	
	
	public static void addItems(WebDriver driver,String[] itemsNeeded) {
		int j =0;

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
				
				if (j==itemsNeeded.length)
						break;
			}

		}
	}

}
