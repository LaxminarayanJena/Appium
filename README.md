# Appium
Appium-selenium 3.0 API for Mobile Automation Testing

![appium](https://user-images.githubusercontent.com/24494133/42090141-d006b1c2-7bbd-11e8-9647-b751c9f7c986.png)

### LATEST VERSION
Android 13 - tiramisu August 15, 2022 </br>
Android 12 -Snow cone 11 -October 4, 2021 </br>
Android 11- red velvet cake September 8, 2020 </br>
Android 10 10 - quince tart sept 3 2019  api level29 </br>
Android 9 pie  august 6 2018 </br>

appium java client 8.2.0 - Aug 30, 2022 </br>
selenium-4.4.0 </br>
appium gui desktop-1.22 </br>
Xcode -14 </br>
latest version of iOS - iOS 15.5 </br>
latest mac Version macOS 13: Ventura  – June 6, 2022  </br>
latest mac Version macOS 12: Monterey (Star) – October 25, 2021 (Latest: 12.4) </br>

.ipa -ios file extension </br>
# crash logs
settings-privacy-analytics and improvements-analyticsdata- filenam.ips
# ADB Commands
1)adb devices

2)adb shell dumpsys window windows | grep -E 'mCurrentFocus' </br>

adb shell </br>
dumpsys activity activities </br>

3)adb tcpip 5555

4)adb connect 192.168.0.101
(*ip of wifi of mobile) 

5)adb logcat>/Eclipse/logcat.txt 

6)adb logcat --buffer=crash </br>
7)adb logcat AndroidRuntime:E *:S </br>
8)adb install -r TheAppName.apk

--------------------------------------------

emulator -avd kitkat



--------------------------------------------



adb install "D:\software\testing software\MOBILE TESTING\APKS\HTML5testWebView.apk"

chrome://inspect/#devices

# AndroidStudio emulator
![avd settings](https://user-images.githubusercontent.com/24494133/42304144-68bd9b46-8042-11e8-99a6-5cd42b342882.PNG)
# Appium Architecture
![appiumarchitecture](https://user-images.githubusercontent.com/24494133/43879019-8efea5be-9bbf-11e8-9264-dcef7e7fab1e.png)

### Locators
-ios predicate string </br>
-ios class chain </br>
```
let elem = app.cells.matchingPredicate(NSPredicate(format: "label CONTAINS 'Olivia'"))
elem.click();
HashMap<String, String> scrollObject = new HashMap<String, String>();
scrollObject.put("predicateString", "label == 'ADD TO CART'");

driver.findElement(MobileBy.iOSClassChain(selector));

```
AccessibilityId- content-desc </br>
AndroidUIAutomator -text </br>
driver.findElementByAndroidUIAutomator("new UiSelector().text(\"i accept adds\")").click() </br>
ClassName -class </br>
CssSelector </br>
Id- ResourceId  </br>
LinkText </br>
Name -text</br>
PartialLinkText </br>
TagName </br>
XPath- driver.findElementByXPath("//ClassName[@content-desc='content-desc']").click() </br>
 driver.findElementByXPath("//ClassName[@index='1']").click() </br>
 
 ### IOS Capabilities
 
 ```
DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("platformVersion", "14.5");
        caps.setCapability("deviceName", "iPhone 12");
        caps.setCapability("automationName", "XCUITest");
        caps.setCapability("app", "/path/to/your/app.app");
	caps.setCapability("udid", ""); //This capability represents the Unique Device Identifier (UDID) of the physical iOS device to be used for automation. You can find the UDID of your device in iTunes or by connecting it to Xcode.
	
	caps.setCapability("xcodeOrgId", "");//These capabilities are required when automating on real devices and are used for code signing. They correspond to your Apple Developer Team ID and the signing identity to use for the app, respectively.
	
	caps.setCapability("bundleId", "hh"); // specifies the bundle identifier of the application. This is required if you want to automate an installed application on a real device or simulator.

        URL url = new URL("http://localhost:4723/wd/hub");
        IOSDriver<IOSElement> driver = new IOSDriver<>(url, caps);
``` 
```
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
``` 
### Android ScrollAnd Swipe
``` 
   public static void androidScroll1() {
		Dimension dim = driver.manage().window().getSize();
		int x = dim.getWidth() / 2;
		int startY = (int) (dim.getHeight() * 0.2);
		int endY = (int) (dim.getHeight() * 0.8);
		//downward scroll
		TouchAction t = new TouchAction(driver);
		t.press(PointOption.point(x, startY)).moveTo(PointOption.point(x, endY)).release().perform();
}
-----------------------------------------------------------
public static void scrollUsingText(String visibleText) {
		((FindsByAndroidUIAutomator<MobileElement>) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ visibleText + "\").instance(0))");
	}

	}
```
Switch apps
```
 driver.startActivity(new Activity(settingsAppPackageName, settingsAppActivityName));

```
### Switch apps native to web and web to native
```
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class AppToWebViewSwitchExample {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android"); // Replace with "iOS" for iOS devices
        // Set other desired capabilities

        URL url = new URL("http://localhost:4723/wd/hub");
        AppiumDriver<WebElement> driver = new AndroidDriver<>(url, caps); // Replace with IOSDriver for iOS devices

        // Perform native app automation here

        // Switch to the web view context
        Set<String> contextHandles = driver.getContextHandles();
        for (String contextHandle : contextHandles) {
            if (contextHandle.startsWith("WEBVIEW")) {
                driver.context(contextHandle);
                break;
            }
        }

        // Perform web automation here
        // Example: Find and interact with a web element
        WebElement element = driver.findElement(MobileBy.cssSelector("input[name='username']"));
        element.sendKeys("example@gmail.com");

        // Switch back to the native app context (optional)
        driver.context("NATIVE_APP");

        // Perform native app automation here again

        // Quit the driver
        driver.quit();
    }
}

```
### CRASH
```
To view crash logs in Android, you can use the following methods:

Android Studio:

Connect your Android device to your computer using a USB cable.
Open Android Studio and select "Logcat" from the bottom panel.
Filter the logcat output by selecting the device and the application you're interested in.
You can view crash logs in the logcat window by looking for messages with "E/AndroidRuntime" or "FATAL EXCEPTION."
ADB Command Line:

Ensure that you have Android Debug Bridge (ADB) installed on your computer.
Connect your Android device to your computer using a USB cable.
Open a terminal or command prompt and navigate to the directory where ADB is installed.
Run the command: adb logcat -b crash
This command will display the crash logs for your connected device.
Third-party Crash Reporting Tools:

There are several third-party crash reporting tools available, such as Crashlytics (Fabric), Firebase Crashlytics, Bugsnag, and Sentry. These tools provide more advanced crash reporting features and can help you analyze crashes remotely.


To view crash logs in iOS, you can follow these steps:

settings-privacy-analytics and improvements-analyticsdata- filenam.ips
Xcode:

Connect your iOS device to your Mac using a USB cable.
Open Xcode on your Mac.
Select "Window" from the menu bar and then choose "Devices and Simulators."
In the "Devices" tab, select your connected iOS device.
Under the "Device Information" section, you will find a "View Device Logs" button. Click on it.
This will open the Console app, where you can see various logs, including crash logs. Look for logs with the "Crash" or "Exception" type.
```

### Non Functional TestCases
```
### Performance Testing:
Measure the response time of the application when performing common tasks such as opening the app, navigating between screens, and loading data.
Test the application's performance under different network conditions, such as 3G, 4G, and Wi-Fi.
Check the application's memory usage and how it handles memory-intensive operations.

### Usability Testing:
Evaluate the user interface (UI) for consistency, clarity, and ease of use.
Test the application's responsiveness to different screen sizes and orientations.
Verify that the text, buttons, and other UI elements are appropriately sized and aligned for different devices.

### Compatibility Testing:
Test the application on various mobile devices with different operating systems (iOS, Android) and versions.
Check if the application functions correctly on different screen resolutions and aspect ratios.
Verify compatibility with different mobile browsers, if applicable.

### Security Testing:
Test the application for vulnerabilities such as data leakage, unauthorized access, or insecure data storage.
Check if the application handles authentication and authorization properly.
Test the application's resistance to common security threats, such as SQL injection or cross-site scripting (XSS).

### Battery Consumption Testing:
Measure the application's impact on device battery life by running it for a prolonged period.
Test the application's behavior when the device's battery is low or in power-saving mode.
Check if the application correctly handles battery-related events, such as entering or exiting battery-saving mode.

### Localization Testing:
Test the application with different languages and locales to ensure proper translation and formatting of text.
Verify that the application supports date, time, and number formats specific to different regions.
Check if the application's UI adapts to different languages without truncating or overlapping text.

### Network Connectivity Testing:
Test the application's behavior when the network connection is weak, intermittent, or lost.
Verify that the application handles network errors gracefully and provides appropriate error messages.
Test the application's offline capabilities, such as caching data for offline use and synchronizing when the connection is restored.

```

### Functional TestCases
```
### Installation and Launch:
Verify that the application can be installed successfully from the app store or by side-loading.
Test the application launch to ensure it opens without any errors or crashes.

### User Registration and Authentication:
Test the registration process to ensure users can create new accounts successfully.
Verify that users can log in using valid credentials and are denied access with invalid credentials.
Test the "Forgot Password" functionality to reset passwords and verify successful login after the reset.

### User Interface (UI) and Navigation:
Validate that the UI elements (buttons, menus, forms) are displayed correctly and are functional.
Test the navigation between screens and ensure that users can navigate smoothly and without any glitches.
Verify that all UI elements respond appropriately to user interactions (taps, swipes, etc.).

### Input Validation:
Test input fields to ensure that they accept valid data and reject invalid or incorrectly formatted data.
Verify that appropriate error messages are displayed when invalid data is entered.
Test the character limits and input constraints for various fields.
 
### Functional Workflows:
Test the main functionalities of the application, such as creating, editing, and deleting data (e.g., creating a new note, editing a contact, deleting a task).
Validate that all workflows and business processes within the application are functioning as expected.

### Integration with External Services:
Test the integration of the application with external services, such as social media platforms, payment gateways, or third-party APIs.
Verify that data is transmitted correctly and securely between the application and the external services.

### Data Handling:
Test data persistence and retrieval, ensuring that user data is saved and retrieved accurately.
Validate that data is synchronized correctly between the device and any associated cloud services, if applicable.
Test scenarios involving large amounts of data to ensure optimal performance and data integrity.

### Push Notifications and Alerts:
Test push notifications to ensure they are sent and received correctly on the device.
Verify that alerts, notifications, and reminders within the application are displayed at the appropriate times and contain accurate information.

### Compatibility:
Test the application's compatibility with different mobile devices, operating systems, and versions.
Validate that the application functions correctly on various screen sizes, resolutions, and orientations.

### Localization:
Test the application with different languages and locales to ensure proper translation and display of text.
Verify that date, time, and number formats are displayed correctly based on the user's locale settings.
```


### Challenges
```
###  Device Fragmentation: The Android ecosystem, in particular, is highly fragmented with a wide range of device manufacturers, screen sizes, resolutions, and Android OS versions. This makes it challenging to ensure your mobile application works correctly across all these variations.

###  Platform Variability: Mobile automation needs to cater to both Android and iOS platforms, which have different architectures and require different tools and technologies.

###  Constant Updates: Mobile operating systems, app frameworks, and mobile applications are frequently updated. Keeping automation scripts up-to-date with these changes is a continuous challenge.

###  Emulator vs. Real Device: Testing on emulators or simulators is not always representative of real-world device performance and behavior. Real devices can be costly to maintain and access.

###  Device Management: Acquiring, configuring, and maintaining a fleet of mobile devices for testing can be expensive and challenging.

###  App Store Approval: On iOS, getting automation tools and frameworks approved by Apple for testing can be a challenge.

###  Intermittent Failures: Mobile automation tests can be prone to intermittent failures due to network issues, device-specific quirks, or other external factors.

###  Test Data: Handling test data for mobile automation can be complex. You need to ensure that test data is set up correctly and is in the expected state for each test.

###  Performance Testing: Mobile applications need to perform well under various network conditions (2G, 3G, 4G, Wi-Fi) and on devices with varying levels of performance. Ensuring this can be challenging.

###  Security Testing: Ensuring that your mobile app is secure is crucial, but performing security testing in an automated fashion can be complex due to the need for different tools and expertise.

###  Cross-Browser Testing: When dealing with mobile web applications, you may need to perform cross-browser testing, which can be complex on mobile devices.

###  Integration with Other Tools: Integrating mobile automation into the CI/CD pipeline and other tools like test management systems and issue tracking systems can be challenging.

###  Test Script Design: Designing effective and maintainable test scripts for mobile automation can be a challenge, as the scripts need to account for various device states and interactions.

###  Test Execution Time: Mobile automation tests can be time-consuming, especially when run on a large number of devices, which can slow down the development process.

###  Accessibility Testing: Ensuring that mobile applications are accessible to users with disabilities is important but can be challenging to automate.
```
