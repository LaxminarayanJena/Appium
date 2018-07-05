package testcases;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class DropDown {
	
	//IOSElement,AndroidElemnt,MobileElemnt,WebElement

	public static AndroidDriver<WebElement> driver;

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		capabilities.setCapability("deviceName", "Android");
		
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		driver.get("http://wikipedia.org");
		WebElement dropdown=driver.findElement(By.id("searchLanguage"));
		new Select(dropdown).selectByVisibleText("Galego");
		
		System.out.println("-------------------printing no of links ---------------------");
		
		List<WebElement> values= dropdown.findElements(By.tagName("option"));
		System.out.println(values.size());
		for(WebElement value : values)
		{
			System.out.println(value.getAttribute("lang"));
		}
		
		System.out.println("-------------------printing all links ---------------------");
		
		List<WebElement>  links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		for (WebElement link :links){
			System.out.println(link.getAttribute("href")+ "-----" + link.getText());
		}
		
		System.out.println("------printing links of specific block-----------------------");
		
		 WebElement block= driver.findElement(By.cssSelector(".other-projects"));
		 List<WebElement>  blocklinks = block.findElements(By.tagName("a"));
			for (WebElement blocklink :blocklinks){
				System.out.println(blocklink.getAttribute("href")+ "-----" + blocklink.getText());
	
		driver.quit();
		

	}
}
}
