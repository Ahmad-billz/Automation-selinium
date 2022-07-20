import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class dynamicalValuesA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Program Files/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C://Program Files/extension_4_3_6_0.crx"));
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://qaclickacademy.com/practice.php");
		driver.findElement(By.cssSelector("label[for='honda'] input")).click();		
		
		String opt=driver.findElement(By.cssSelector("*[id='checkbox-example'] fieldset label[for='honda']")).getText();
		
		WebElement staticDropdown = driver.findElement(By.id("dropdown-class-example"));
		
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByVisibleText(opt);
		driver.findElement(By.cssSelector(".pull-right input[id='name']")).sendKeys(opt);
		driver.findElement(By.id("alertbtn")).click();
		
		String alertMsg =  driver.switchTo().alert().getText();
		if (alertMsg.contains(opt))
		{
			System.out.println("Success");
			driver.switchTo().alert().accept();
		}
		else
		{
			System.out.println("Unsuccessfull");
			driver.switchTo().alert().accept();
		}
	}
}
