import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calender {

	public static void main(String[] args) throws InterruptedException {
		{
			System.setProperty("webdriver.chrome.driver","C://Program Files/chromedriver.exe");					 
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.path2usa.com/travel-companions");
			System.out.println(driver.getTitle());
			Thread.sleep(4000);			
			driver.findElement(By.id("ez-accept-all")).click();

			driver.findElement(By.xpath("//input[@id='travel_date']")).click();
			WebElement month = driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='datepicker-switch']"));
			while(!month.getText().contains("December 2022"))
			{
				driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
				System.out.println(month.getText());
			}

			int count= driver.findElements(By.cssSelector("td[class='day']")).size();
			for(int i=0;i<count;i++)
			{
				String text=driver.findElements(By.xpath("//td[@class='day']")).get(i).getText();
				if(text.equalsIgnoreCase("26"))
				{
					// driver.findElements(By.cssSelector("td[class*='day']")).get(i).click();
					driver.findElements(By.xpath("//td[@class='day']")).get(i).click();
					System.out.println(text);
					break;
				}
			}
			}
	}
}

