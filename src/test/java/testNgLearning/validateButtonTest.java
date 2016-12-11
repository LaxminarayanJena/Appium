package testNgLearning;

import org.testng.Assert;
import org.testng.annotations.Test;

public class validateButtonTest {

	@Test(groups="high")
	public void validateButton()
	{
		String expectedText="submit";
		String actualText="ok";
		
		/*if(expectedText.equals(actualText))
		{
			System.out.println("test case pass");
		}
		else
		{
			System.out.println("test case fail");
		}*/
		
		Assert.assertEquals(actualText, expectedText);
		//Assert.assertTrue(isElementPresent(""));
		
	}
}
