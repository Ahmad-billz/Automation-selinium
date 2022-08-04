import java.io.File;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Program Files/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C://Program Files/extension_4_3_6_0.crx"));

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://qaclickacademy.com/practice.php");

		// count of links on page
		System.out.println(driver.findElements(By.tagName("a")).size());

		//count of links in footer
		WebElement footer = driver.findElement(By.id("gf-BIG"));		// limiting the scope of webDriv er
		System.out.println(footer.findElements(By.tagName("a")).size()); // using footer.find instead of driver.find

		//count of links in the left-most column of the footer
		WebElement columnLM = driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columnLM.findElements(By.tagName("a")).size());

		//click each link in the left-most column  
		for(int i=1; i<columnLM.findElements(By.tagName("a")).size(); i++)
		{
			String clickAndOpenInNewTab = Keys.chord(Keys.CONTROL,Keys.ENTER);

			columnLM.findElements(By.tagName("a")).get(i).sendKeys(clickAndOpenInNewTab);
			Thread.sleep(3000L);
		}
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();

		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle() );
		}



	}

}
