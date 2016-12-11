package testNgLearning;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
	
	
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("BeforeSuite-This will execute before the Test Suite");
	}
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("AfterSuite-This will execute after the Test Suite");
		//sending old mail report- should not give after or before suite
	}
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("BeforeTest-This will execute before the Test");
	}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("AfterTest-This will execute after the Test");
	}
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("BeforeMethod-This will execute before every Method");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("AfterMethod-This will execute after every Method");	
	}
	
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("BeforeClass-This will run before the first test method in the current class is invoked.");	
	}
	
	@AfterClass
	public void afterclass()
	{
		System.out.println("AfterClass-This will  run after the last test method in the current class is invoked.");	
	}
	@Test(priority=1, groups="high")
	
	public void doLogin()
	{
	System.out.println("1)---Executing login test----");	
	}

@Test(priority=2, groups="low")
	
	public void composeEmail()
	{
	System.out.println("2)---Composing Email-----");	
	}

@Test(priority=3, groups="low")

public void checkinbox()
{
System.out.println("3)---Checking inbox------");	
}
}
