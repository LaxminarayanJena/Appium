package testcases;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SevenDragAndDrop {

	public static AndroidDriver<MobileElement> driver;

	public static void main(String[] args) throws MalformedURLException,InterruptedException 
	{

		File app = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\APKS\\Drag Sort Demos.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		
		
		//1stway- driver.findElements(By.id("com.mobeta.android.demodslv:id/activity_title")).get(0).click();
		
		/* 2nd way-
		 System.out.println(driver.getPageSource());
		we will get xml .open the xml in chrome and find the xpath		
		driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Basic')]")).click();
		*/		
		//3rd way
		String text="Basic";
		driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\""+text+"\")").click();
		
		
       WebDriverWait wait = new WebDriverWait(driver,5);
       wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.mobeta.android.demodslv:id/text")));
       System.out.println(driver.getPageSource());
     //android.widget.TextView[contains(@text,'Brad')]/preceding-sibling::android.widget.ImageView
       MobileElement draggable =driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Brad')]/preceding-sibling::android.widget.ImageView"));
       MobileElement droppable=driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Kurt')]/preceding-sibling::android.widget.ImageView"));
	   TouchAction action = new TouchAction(driver);
	   action.longPress(draggable).moveTo(droppable).release().perform();
	   
       
       
       driver.quit();
	}

}