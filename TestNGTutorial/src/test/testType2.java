package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testType2 {

	@Test(groups= {"Smoke"})
	public void ploan() {
		System.out.println("good");
	}
	
	@BeforeTest
	public void bfTest() {
		System.out.println("I am BeforeTest. I will run first");
	}
	
	
}
