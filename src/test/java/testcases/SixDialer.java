package testcases;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SixDialer {

	public static AndroidDriver<MobileElement> driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		
		 capabilities.setCapability("deviceName", "Android");
		 capabilities.setCapability("appPackage", "com.samsung.android.contacts");
		 capabilities.setCapability("appActivity", "com.android.dialer.DialtactsActivity");
		 
		
		
		 // "C:/Users/Poltu/AppData/Local/Android/sdk/tools/uiautomatorviewer"
		
		 
		 driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	
		 driver.findElement(By.id("com.samsung.android.contacts:id/two")).click();
		 driver.findElement(By.id("com.samsung.android.contacts:id/six")).click();
		 driver.findElement(By.id("com.samsung.android.contacts:id/seven")).click();
		 driver.findElement(By.id("com.samsung.android.contacts:id/dialButton2")).click();
		 driver.quit();
	
	
		
	}

}
