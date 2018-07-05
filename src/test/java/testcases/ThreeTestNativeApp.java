package testcases;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ThreeTestNativeApp {

	public static AndroidDriver driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		

		File app = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\APKS\\selendroid-test-app-0.17.0.apk");		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		 capabilities.setCapability("deviceName", "Android");
		 capabilities.setCapability("app", app.getAbsolutePath());
		 driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	
	
		 driver.quit();
	}

}
