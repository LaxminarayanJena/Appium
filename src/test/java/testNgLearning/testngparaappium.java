package testNgLearning;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.ExcelReader;

public class testngparaappium {

	public static ExcelReader excel;
	public static AndroidDriver driver;
	public static Logger log= Logger.getLogger("devpinoyLogger");
	public static AppiumDriverLocalService service;
	
	@BeforeMethod
	public  void SetUp() throws MalformedURLException,InterruptedException {

		File app = new File("C:\\Users\\C5249422\\Downloads\\selendroid.apk");
		 service = AppiumDriverLocalService
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
		

		
	}
	
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
		log.debug("Application closed");
		service.stop();
	}
	

	@Test(dataProvider = "getData")
	public void loginTest(String username, String password) {
		driver.findElementById("io.selendroid.testapp:id/my_text_field")
		.sendKeys(username);
	}

	@DataProvider
	public static Object[][] getData()

	{
		if (excel == null) {
			excel = new ExcelReader(System.getProperty("user.dir")
					+ "\\src\\test\\resources\\TestData\\testdata.xlsx");
			

		}
		
		
		String sheetName = "LoginTest";
		int rows = excel.getRowCount(sheetName);
		int cols= excel.getColumnCount(sheetName);
	
		Object[][] data = new Object[rows-1][cols];
	
		for (int rowNum=2 ; rowNum <= rows ; rowNum++)
		{
			for (int colNum=0 ; colNum<cols; colNum++)
			{
			data[rowNum-2][colNum]	= excel.getCellData(sheetName, colNum, rowNum);
			}
		}
		return data;

	}
}
