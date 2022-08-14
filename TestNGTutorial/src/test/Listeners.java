package test;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//ITestListners interface implements TestNG listeners
public class Listeners implements ITestListener {
	
	@Override public void onTestStart(ITestResult result) {
		
	}
	 
	
	@Override public void onTestSuccess(ITestResult result) {
		System.out.println("Test passed");
	}
	
	
	@Override public void onTestFailure(ITestResult result) {
		//screenshot code of the failed
		//response if API is failed
		System.out.println(result.getName()+ " has been failed----------------");
	}
	
	
	@Override public void onTestSkipped(ITestResult result) {
		System.out.println("A test named "+ result + " is skipped");
	}
	
	
	@Override public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	
	@Override public void onTestFailedWithTimeout(ITestResult result) {
		
	}
	
	@Override public void onStart(ITestContext context) {
		
	}
	
	@Override public void onFinish(ITestContext context) {
		
	}
	
}
 
