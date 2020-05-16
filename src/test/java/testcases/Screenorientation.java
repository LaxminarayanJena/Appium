package rough;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Screenorientation {

	public static AndroidDriver<MobileElement> driver;

	public static void main(String[] args) throws MalformedURLException {

		File app = new File(System.getProperty("user.dir") + "/src/test/resources/apks/Amazon_shopping.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appActivity", "com.amazon.mShop.sso.SigninPromptActivity");
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		
		

	}

	
	public static void orientation() {
		
			driver.rotate(ScreenOrientation.LANDSCAPE);
			driver.rotate(ScreenOrientation.PORTRAIT);
		
		
		
	}

	

		
	}


