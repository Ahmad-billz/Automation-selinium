package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testType4 {

	@Parameters({"URL"})
	@Test
	public void WebloginHomeLoan(String uname) {
		System.out.println("webloginHome");
		System.out.println(uname);
	}

	@Test (groups= {"Smoke"})
	public void MobileLoginHomeLoan() {
		System.out.println("mobileloginHome");
	}

	@Test
	public void LoginAPIHomeLoan() {
		System.out.println("APIloginHome");
	}
	
}
