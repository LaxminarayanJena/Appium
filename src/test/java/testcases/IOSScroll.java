package rough;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class IOSScroll {

	public static AndroidDriver<MobileElement> driver;

	public static void main(String[] args) throws MalformedURLException {

		File app = new File(System.getProperty("user.dir") + "/src/test/resources/apks/Amazon_shopping.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appActivity", "com.amazon.mShop.sso.SigninPromptActivity");
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

	}

	  public void iOSScrollToElement() {
		  RemoteWebElement element = (RemoteWebElement)driver.findElement(By.name("test-ADD TO CART"));
		  String elementID = element.getId();
		  HashMap<String, String> scrollObject = new HashMap<String, String>();
		  scrollObject.put("element", elementID);
//		  scrollObject.put("direction", "down");
//		  scrollObject.put("predicateString", "label == 'ADD TO CART'");
//		  scrollObject.put("name", "test-ADD TO CART");
		  scrollObject.put("toVisible", "sdfnjksdnfkld");
		  driver.executeScript("mobile:scroll", scrollObject);
	  }
	  
	  
	  public MobileElement scrollToElement() {	  
			return (MobileElement) ((FindsByAndroidUIAutomator) driver).findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector()" + ".scrollable(true)).scrollIntoView("
							+ "new UiSelector().description(\"test-Price\"));");
	  }
	  
	  public MobileElement scrollToElement1() {	  
			return (MobileElement) ((FindsByAndroidUIAutomator) driver).findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector()" + ".description(\"parentid\")).scrollIntoView("
							+ "new UiSelector().description(\"childid\"));");
	  }

	  //android.widget.ScrollView .. works only for accesbilty id
}
