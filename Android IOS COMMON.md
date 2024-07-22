# structure

```
src
└── main
    ├── java
    │   └── com
    │       └── example
    │           ├── pages
    │           │   └── CommonPage.java
    │           └── utils
    │               └── DriverManager.java
    └── resources
        └── features
            └── your_feature_file.feature

```

```
Feature: Common Feature

  Scenario: Verify common element on Android
    Given I launch the app on "android"
    Then I should see the common element

  Scenario: Verify common element on iOS
    Given I launch the app on "ios"
    Then I should see the common element


```

```

package com.example.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class CommonPage {

    // Declare the driver
    private AppiumDriver<MobileElement> driver;

    // Constructor
    public CommonPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Common Locators
    @AndroidFindBy(id = "android_locator_id")
    @iOSFindBy(id = "ios_locator_id")
    private MobileElement commonElement;

    // Getter method for the element
    public MobileElement getCommonElement() {
        return commonElement;
    }
}

```

```
package com.example.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {

    private static AppiumDriver<MobileElement> driver;

    public static AppiumDriver<MobileElement> getDriver(String platform) throws MalformedURLException {
        if (driver == null) {
            if (platform.equalsIgnoreCase("android")) {
                driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), getAndroidCapabilities());
            } else if (platform.equalsIgnoreCase("ios")) {
                driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), getIOSCapabilities());
            }
        }
        return driver;
    }

    private static DesiredCapabilities getAndroidCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("appPackage", "your.app.package");
        capabilities.setCapability("appActivity", "your.app.activity");
        return capabilities;
    }

    private static DesiredCapabilities getIOSCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone Simulator");
        capabilities.setCapability("bundleId", "your.app.bundleId");
        return capabilities;
    }
}

```

```

package com.example.stepdefs;

import com.example.pages.CommonPage;
import com.example.utils.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CommonSteps {

    private CommonPage commonPage;

    @Given("I launch the app on {string}")
    public void iLaunchTheAppOn(String platform) throws Exception {
        commonPage = new CommonPage(DriverManager.getDriver(platform));
    }

    @Then("I should see the common element")
    public void iShouldSeeTheCommonElement() {
        Assert.assertTrue(commonPage.getCommonElement().isDisplayed());
    }
}
```
