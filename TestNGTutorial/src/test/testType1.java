package test;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class testType1 {
	
	@Test
	public void Demo() {
		System.out.println("Hello");
		Assert.assertTrue(false);
	} 
	
	@Test
	public void secondTest() {
		System.out.println("Bye");
		Assert.assertTrue(false);
	}
	
	@AfterTest
	public void adtrTest() {
		System.out.println("I am AfterTest, I will execute at the end of the test.");
	}
	
	@AfterSuite
	public void afsuite() {
		System.out.println("I am AfterSuite. I come at the Last");
	}
	
	
	
}
