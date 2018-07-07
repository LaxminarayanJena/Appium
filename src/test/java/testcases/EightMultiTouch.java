package testcases;

import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;


public class EightMultiTouch {

	public static AndroidDriver<MobileElement> driver;

	public static void main(String[] args) throws MalformedURLException,InterruptedException 
	{
		File app = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\APKS\\Multitouch Test.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "multitouchpro.tests");
		capabilities.setCapability("appActivity", "multitouchpro.tests.Multitouch");
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

	
		TouchAction action1 = new TouchAction(driver).tap(300, 400).waitAction(1000);
		TouchAction action2 = new TouchAction(driver).tap(500, 600).waitAction(1000);
		TouchAction action3 = new TouchAction(driver).tap(700, 800).waitAction(1000);
		new MultiTouchAction(driver).add(action1).add(action2).add(action3).perform();
		
	
		
		driver.quit();
		
      
	}

}