package testcases;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestNativeApp1 {

	public static AndroidDriver driver;
	public static Logger log= Logger.getLogger("devpinoyLogger");
	public static void main(String[] args) throws MalformedURLException,
			InterruptedException {

		File app = new File("C:\\Users\\C5249422\\Downloads\\selendroid.apk");
		AppiumDriverLocalService service = AppiumDriverLocalService
				.buildService(new AppiumServiceBuilder()
						.usingDriverExecutable(
								new File("c:\\Program Files\\nodejs\\node.exe"))
						.withAppiumJS(
								new File(
										"C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js"))
						.withLogFile(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\logs\\logs.txt")));
										

		service.start();

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
		log.debug("Application launched");
		driver.findElementById("io.selendroid.testapp:id/my_text_field")
				.sendKeys("hello");

		driver.quit();
		log.debug("Application closed");
		service.stop();
	}

}
