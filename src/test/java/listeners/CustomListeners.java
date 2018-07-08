package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomListeners implements ITestListener ,ISuiteListener {
	public void onStart(ISuite suite) {
		System.out.println("Starting");
		//implemented from ISuiteListener Execute once before starting of suite 
		
	}

	public void onFinish(ISuite suite) {
		System.out.println("ending");
		// implemented from ISuiteListener Execute once after ending of suite
	}
	public void onTestStart(ITestResult result) {
		
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("PASS !! PASS!! PASS!!");
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("ScreenshotCaptured");
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("<a target=\"_blank\" href=\"Capture2.JPG\">Screenshot Captured</a>");
		Reporter.log("<br><a  target='_blank' href=\"Capture2.JPG\" ><img height=200, width=200, src=\"Capture2.JPG\" alt=\"\"/></img></a>");
		Reporter.log("Screenshot captured");
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	

}
