package testcases;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FiveNativeElementsAndIsElementPresent {

	public static AndroidDriver<MobileElement> driver;
	public static boolean isElementPresent(String id)
	{
		try {
			driver.findElement(By.id(id));
			return true;
		} catch (Exception e) {
			return false;	
		}
		
	}
	

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		
		  capabilities.setCapability("deviceName", "Android");
		 capabilities.setCapability("appPackage", "io.selendroid.testapp");
		 capabilities.setCapability("appActivity", "io.selendroid.testapp.HomeScreenActivity");
		 
		 driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		 if(driver.isLocked())
		 {
			 driver.unlockDevice();
		 }
		 driver.findElement(By.id("io.selendroid.testapp:id/my_text_field")).sendKeys("hello");
		 driver.hideKeyboard();
		 
		 System.out.println(driver.findElements(By.className("android.widget.Button")).size());
		 List<MobileElement>btn =driver.findElements(By.className("android.widget.Button"));
		 for(MobileElement button :btn)
		 {
			if (button.getAttribute("text").contains("Display text view"))
		
			button.click();
			
		
		 }
		 
		 driver.openNotifications();
		 if(isElementPresent("com.android.systemui:id/clear_all"))
		 
		 {
			 driver.findElement(By.id("com.android.systemui:id/clear_all")).click();
		 }
		 else
		 {
			
				driver.pressKeyCode(AndroidKeyCode.BACK);
		 }
		 
		 Thread.sleep(5000);
		 driver.quit();
		
		
	}

}
