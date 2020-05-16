package rough;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class AndroidSwipe {

	public static AndroidDriver<MobileElement> driver;

	public static void main(String[] args) throws MalformedURLException {

		File app = new File(System.getProperty("user.dir") + "/src/test/resources/apks/Amazon_shopping.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appActivity", "com.amazon.mShop.sso.SigninPromptActivity");
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		
		

	}

	
	public static void androidSwipe() {
		Dimension dim = driver.manage().window().getSize();
		int x = dim.getWidth() / 2;
		int startY = (int) (dim.getHeight() * 0.8);
		int endY = (int) (dim.getHeight() * 0.2);
		
		TouchAction t = new TouchAction(driver);
		t.press(PointOption.point(x, startY)).moveTo(PointOption.point(x, endY)).release().perform();

	}

	

		
	}


