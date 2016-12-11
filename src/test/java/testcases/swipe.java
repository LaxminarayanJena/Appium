package testcases;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

public class swipe {
	public static AndroidDriver<MobileElement> driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		 capabilities.setCapability("deviceName", "Android");
		 capabilities.setCapability("appPackage", "com.fortysevendeg.android.swipelistview");
		 capabilities.setCapability("appActivity", "com.fortysevendeg.android.swipelistview.sample.activities.SwipeListViewExampleActivity");
		 
		 
		 driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		 String text="Gaao";
         MobileElement ele=driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"android:id/content\")).scrollIntoView(new UiSelector().textContains(\""+text+"\"))");
		 driver.swipe(ele.getLocation().x+376, ele.getLocation().y, ele.getLocation().x+127, ele.getLocation().y, 5000);
		 driver.quit();
		 
	
	
		
	}

}