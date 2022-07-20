
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class nestedFramesA {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C://Program Files/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com");
		driver.findElement(By.linkText("Nested Frames")).click();
		driver.switchTo().frame(driver.findElement(By.name("frame-top")));
		//driver.findElement(By.cssSelector("frameset[name = 'frameset-middle']"));
		driver.switchTo().frame("frame-middle");
		System.out.println(driver.findElement(By.id("content")).getText());
		
	}

}
