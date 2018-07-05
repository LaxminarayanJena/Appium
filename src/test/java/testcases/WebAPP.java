package testcases;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebAPP {

	public static AndroidDriver driver;
	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		capabilities.setCapability("deviceName", "Android");
		
		
		 driver = new  AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		 driver.get("http://google.com");
		 driver.findElement(By.name("q")).sendKeys("appium");
		 driver.quit();
		
	}

}

//C:\Program Files (x86)\Appium\node_modules\appium\node_modules\appium-chromedriver\chromedriver\win