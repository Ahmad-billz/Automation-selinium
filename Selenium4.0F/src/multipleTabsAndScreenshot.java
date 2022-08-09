

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class multipleTabsAndScreenshot {

	public static void main(String[] args) throws IOException {
		ChromeOptions opt = new ChromeOptions();
		opt.addExtensions(new File("C://Program Files/extension_4_3_6_0.crx"));		
		System.setProperty("webdriver.chrome.driver", "C://Program Files/chromedriver.exe");
		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://rahulshettyacademy.com/angularpractice");
		driver.switchTo().newWindow(WindowType.TAB); // windowType can either be T AB or WINDOW
		
		//switching tabs/windows
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentWindowId = it.next();
		String childWindowId = it.next();
		driver.switchTo().window(childWindowId);
		driver.get("https://rahulshettyacademy.com/");
		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))
				.get(1).getText();
		driver.switchTo().window(parentWindowId);
		WebElement name= driver.findElement(By.cssSelector("[name='name']"));
		name.sendKeys(courseName);
		
		// screenshot of an element
		File file=name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("caputeredWithSelenium.png"));
		
		//Get Height and width 
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
		
		System.out.println(name.getRect().getHeight());//.getDimensions is not really needed
		//driver.quit();
		
		
		
		
		
		
		
	}

}



