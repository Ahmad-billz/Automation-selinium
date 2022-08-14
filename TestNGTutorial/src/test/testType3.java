package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testType3 {

	@Parameters({"URL","APIKey"})
	@Test
	public void WebloginCarLoan(String urlname, String key) {
		System.out.println("webloginCar");
		System.out.println(urlname);
		System.out.println(key);
		
	}

	@BeforeSuite
	public void bfsuite() {
		System.out.println("I am BeforeSuite. I am number 1");
	}
	
	@BeforeClass
	public void bfClass() {
		System.err.println("Before running any of the methods of a class");
	}

	
	@AfterClass
	public void afClass() {
		System.err.println("After running all of the methods of a class");
	}
	
	
	@BeforeMethod
	public void beforeEvery() {
		System.out.println("Before every method of testType3");
	}
	
	@AfterMethod
	public void afterEvery() {
		System.out.println("After every method of testType3");
	}
	
	@Test (groups= {"Smoke"})
	public void MobileLoginCarLoan() {
		System.out.println("mobileLogInCar");
	}
	
	@Test(enabled=false)
	public void MobilesinginCarLoan() {
		System.out.println("mobileSigninCar");
	}
	
	
	@Test(dataProvider="getData")
	public void MobilesingoutCarLoan(String username, String password) {	
		System.out.println("Mobile SIGNOUT");
		System.out.println(username);
		System.out.println(password);
	}

	@Test(dependsOnMethods={"WebloginCarLoan","MobilesingoutCarLoan"})
	public void APICarLoan() {
		System.out.println("APIloginCar");
	}
	
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[3][2];
		data[0][0]="firstUname";
		data[0][1]="firstPass";
		data[1][0]="SecondUname";
		data[1][1]="SecondPass";
		data[2][0]="thirdUname";
		data[2][1]="SecondPass";
		return data;
	}
	
	
	
	
	
}
