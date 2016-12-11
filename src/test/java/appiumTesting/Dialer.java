package appiumTesting;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Dialer {

	public static AndroidDriver<MobileElement> driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		
		 capabilities.setCapability("deviceName", "Android");
		 capabilities.setCapability("appPackage", "com.truecaller");
		 capabilities.setCapability("appActivity", "com.truecaller.DialerActivityAlias");
		 
		 
		 driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		 driver.findElement(By.xpath("//*[@class='android.view.View' and @index='4']")).click();
		 driver.findElement(By.xpath("//*[@class='android.view.View' and @index='3']")).click();
		 driver.findElement(By.xpath("//*[@class='android.view.View' and @index='1']")).click();
		 driver.findElement(By.xpath("//*[@class='android.view.View' and @index='3']")).click();
		 driver.findElement(By.xpath("//*[@class='android.view.View' and @index='4']")).click();
		 driver.findElement(By.id("com.truecaller:id/call_button")).click();
		 driver.findElement(By.id("com.android.dialer:id/floating_end_call_action_button")).click();
		 driver.quit();
	
	
		
	}

}
