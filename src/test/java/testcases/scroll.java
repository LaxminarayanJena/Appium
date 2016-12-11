package testcases;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

public class scroll {
	public static AndroidDriver<MobileElement> driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		 capabilities.setCapability("deviceName", "Android");
		 capabilities.setCapability("appPackage", "com.truecaller");
		 capabilities.setCapability("appActivity", "com.truecaller.ui.ContactsActivity");
		 
		 
		 driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		 String text="gp";
		 driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.truecaller:id/contacts_list\")).scrollIntoView(new UiSelector().textContains(\""+text+"\"))").click();
		 
		 driver.quit();
		 
	
	
		
	}

}