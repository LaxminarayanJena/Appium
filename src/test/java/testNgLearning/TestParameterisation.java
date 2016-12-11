package testNgLearning;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParameterisation {
	
	@Test(dataProvider="getData")
	public void loginTest(String username, String password)
	{
		System.out.println(username + "-----" + password);
	}
	
	
	
@DataProvider
	public static Object[][] getData()
	{
		Object[][] data= new Object[2][2];
		data[0][0]="raul";
		data[0][1]="aaaa";
		
		data[1][0]="tom";
		data[1][1]="bbbb";
		return data;
		
		
	}
}
