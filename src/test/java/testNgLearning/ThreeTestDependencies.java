package testNgLearning;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class ThreeTestDependencies {
	
@Test(priority=1, groups="med")
	
	public void doLogin()
	{
	System.out.println("Executing login test");
	Assert.fail("login not sucessfull");
	}

@Test(priority=2,dependsOnMethods="doLogin", groups="med")
	
	public void composeEmail()
	{
	System.out.println("Composing Email");	
	Assert.assertEquals("hi", "hello");
	System.out.println("ending");
	//above teststep will not execute after it fails. so we have to use soft assertion
	}
@Test(groups="high")
public void isSkip()
{
	throw new SkipException("skipping the method");
	
}

}
