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

public class AndroidScroll {

	public static AndroidDriver<MobileElement> driver;

	public static void main(String[] args) throws MalformedURLException {

		File app = new File(System.getProperty("user.dir") + "/src/test/resources/apks/Amazon_shopping.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appActivity", "com.amazon.mShop.sso.SigninPromptActivity");
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

	}

	// ----------------------------------------------------------------------------------------------------------
	public static void androidScrollUsingCoordinates() {
		MobileElement topCharts = driver.findElement(MobileBy.xpath("//android.widget.TextView[@text = 'Top Charts']"));
		Point point = topCharts.getLocation();
		int startY = point.y;
		int endY = point.y;

		int startX = (int) ((driver.manage().window().getSize().getWidth()) * 0.80);
		int endX = (int) ((driver.manage().window().getSize().getWidth()) * 0.20);

		TouchAction t = new TouchAction(driver);
		t.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(PointOption.point(endX, endY)).release().perform();
	}

	public static void scrollUsingText(String visibleText) {
		((FindsByAndroidUIAutomator<MobileElement>) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ visibleText + "\").instance(0))");
	}

	// ----------------------------------------------------------------------------------------------------------
	public static void androidScroll() {
		Dimension dim = driver.manage().window().getSize();
		int x = dim.getWidth() / 2;
		int startY = (int) (dim.getHeight() * 0.8);
		int endY = (int) (dim.getHeight() * 0.2);

		TouchAction t = new TouchAction(driver);
		t.press(PointOption.point(x, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(PointOption.point(x, endY)).release().perform();
	}

	public static void scrollUsingTouchAction(String direction) {
		Dimension dim = driver.manage().window().getSize();
		int x = dim.getWidth() / 2;
		int startY = 0;
		int endY = 0;

		switch (direction) {
		case "up":
			startY = (int) (dim.getHeight() * 0.8);
			endY = (int) (dim.getHeight() * 0.2);
			break;
		case "down":
			startY = (int) (dim.getHeight() * 0.2);
			endY = (int) (dim.getHeight() * 0.8);
			break;

		}

		TouchAction t = new TouchAction(driver);
		t.press(PointOption.point(x, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(PointOption.point(x, endY)).release().perform();
	}

	public static boolean isDisplayed(final By e) {

		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			WebDriverWait wait = new WebDriverWait(driver, 2);
			return wait.until(new ExpectedCondition<Boolean>() {

				public Boolean apply(WebDriver driver) {
					if (driver.findElement(e).isDisplayed()) {
						return true;
					}
					return false;
				}
			});
		} catch (Exception ex) {
			return false;
		}

	}

	public static void scrollToElement(By e, String direction) {
		for (int i = 0; i < 3; i++) {
			if (isDisplayed(e)) {
				break;
			} else {
				if (direction.equalsIgnoreCase("up")) {
					scrollUsingTouchAction("up");
				} else {
					scrollUsingTouchAction("down");
				}
			}

		}
	}

}
