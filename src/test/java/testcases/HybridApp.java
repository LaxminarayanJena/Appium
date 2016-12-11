package testcases;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HybridApp {

	public static AndroidDriver<MobileElement> driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		 capabilities.setCapability("deviceName", "Android");
		 capabilities.setCapability("appPackage", "com.html5test.webview");
		 capabilities.setCapability("appActivity", "main.java.MainActivity");
		 
		 driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.findElement(By.id("com.html5test.webview:id/et")).clear();
		driver.findElement(By.id("com.html5test.webview:id/et")).sendKeys("google.in");
		driver.findElement(By.id("com.html5test.webview:id/go")).click();
		
		Set<String> contextnames = driver.getContextHandles();
		for (String context:contextnames)
		{
			System.out.println(context);
		}
		driver.context("WEBVIEW_com.html5test.webview");
		
		driver.findElement(By.name("q")).sendKeys("testing");
		Thread.sleep(3000);
		 driver.quit();
		 
	
	
		
	}

}