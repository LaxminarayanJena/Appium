package testNgLearning;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TwovalidateButtonTest {

	@Test(groups="high")
	public void validateButton()
	{
		String expectedText="ok";
		String actualText="submit";
		
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
