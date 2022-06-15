import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitProject {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://Program Files/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		/* driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//implicit wait */
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));   //Explicit wait
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		String textPhrase = driver.findElement(By.cssSelector("div p[class='text-center text-white']")).getText();
		String [] textArray = textPhrase.split("is ");
		String uname = (textArray[1].split(" and"))[0];
		String pass = textArray[2];
		//pass = pass.replaceAll("[^a-zA-Z]", "");
		pass = pass.replace(")", "");
		
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.cssSelector("input[value='user']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#okayBtn")));
		driver.findElement(By.cssSelector("#okayBtn")).click();
		
		WebElement staticDropdown = driver.findElement(By.cssSelector("select[class='form-control']"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByValue("consult");
		driver.findElement(By.name("terms")).click();
		driver.findElement(By.xpath("//input[@id='signInBtn']")).click();
		
		w.until(ExpectedConditions.urlToBe("https://rahulshettyacademy.com/angularpractice/shop"));
		
		List<WebElement> buttons = driver.findElements(By.cssSelector(".btn.btn-info"));
		for (int i = 0; i < buttons.size(); i++) {
			buttons.get(i).click();
		}
		driver.findElement(By.cssSelector(".nav-link.btn.btn-primary")).click();

		
	}

}
