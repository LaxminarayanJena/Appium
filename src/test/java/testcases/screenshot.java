package testcases;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class screenshot {

	public static AndroidDriver<MobileElement> driver;
	public static String destDir;
	public static DateFormat dateFormat;
	
	public static void takeScreenShot() throws IOException{
		
		//directory
		destDir = "screenshots";
		
		//capturing screenshot
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		//Set date
		dateFormat =  new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		
		
		//create folder
		new File(destDir).mkdir();
		
		String destFile = dateFormat.format(new Date())+".png";
		
		
		FileUtils.copyFile(scrFile, new File(destDir+"/"+destFile));
		
		
	}
	
	
	public static String elementScreenshot(WebElement ele)
	{
		
		File screenshotLocation = null;
		try{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		BufferedImage  fullImg = ImageIO.read(scrFile);
		//Get the location of element on the page
		Point point = ele.getLocation();
		//Get width and height of the element
		int eleWidth = ele.getSize().getWidth();
		int eleHeight = ele.getSize().getHeight();
		//Crop the entire page screenshot to get only element screenshot
		BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(), eleWidth,
		    eleHeight);
		ImageIO.write(eleScreenshot, "png", scrFile);

		String fileName = "newscreenshot";
		
		screenshotLocation = new File("./screenshots/" + fileName + ".jpg");
		FileUtils.copyFile(scrFile, screenshotLocation);
		
	     System.out.println(screenshotLocation.toString());
	 
	 
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return screenshotLocation.toString();


	}
	

	public static void main(String[] args) throws InterruptedException, IOException {
		
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		 capabilities.setCapability("deviceName", "Android");
		 capabilities.setCapability("appPackage", "com.truecaller");
		 capabilities.setCapability("appActivity", "com.truecaller.ui.ContactsActivity");
		 
		 
		 driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		 String text="gp";
		 driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.truecaller:id/contacts_list\")).scrollIntoView(new UiSelector().textContains(\""+text+"\"))").click();
		 takeScreenShot();
		 
		 elementScreenshot(driver.findElement(By.id("com.truecaller:id/name_or_number")));
		 driver.quit();
		 
	
	
		
	}

}