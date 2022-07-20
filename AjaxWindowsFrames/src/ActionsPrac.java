import java.io.File;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ActionsPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Program Files/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C://Program Files/extension_4_3_6_0.crx"));
		
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		
		
		/*
		 // key down context click
		 * driver.get("https://www.amazon.com/"); 
		 * Actions a = new Actions(driver);
		 * 
		 * WebElement move = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
		 * 
		 * a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT)
		                          .sendKeys("rtx ").keyUp(Keys.SHIFT).sendKeys("3090").build().perform();
		 * a.moveToElement(move).contextClick().build().perform();
		 */
		
		
		/*
		 * // multiple windows of a page and switching among them
		 
		 * driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		 * driver.findElement(By.cssSelector(".blinkingText")).click(); 
		 * Set<String> windows = driver.getWindowHandles(); 
		 * Iterator<String>it = windows.iterator();
		 * String parentId = it.next(); 
		 * String childId = it.next();
		 * driver.switchTo().window(childId);
		 * System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText()); 
		 * String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].
		 * trim().split(" ")[0]; driver.switchTo().window(parentId);
		 * driver.findElement(By.id("username")).sendKeys(emailId);
		 * 
		 * 
		 */
		

		
		driver.get("https://the-internet.herokuapp.com");
		driver.findElement(By.cssSelector("li a[href='/windows']")).click();
		driver.findElement(By.cssSelector("a[href='/windows/new']")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		String childText = driver.findElement(By.cssSelector("div[class='example'] h3")).getText();
		System.out.println(childText);
		driver.switchTo().window(parentId);
		String parentText = driver.findElement(By.cssSelector("div[class='example'] h3")).getText();
		System.out.println(parentText);
}
}