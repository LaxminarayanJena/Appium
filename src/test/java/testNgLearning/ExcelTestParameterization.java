package testNgLearning;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.ExcelReader;

public class ExcelTestParameterization {

	public static ExcelReader excel;

	@Test(dataProvider = "getData")
	public void loginTest(String username, String password) {
		System.out.println(username + "-----" + password);
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
		System.out.println("Total rows are : " +rows);
		System.out.println("Total cols are : " +cols);
		
		System.out.println(excel.getCellData(sheetName, 0, 2));
		System.out.println(excel.getCellData(sheetName, 1, 2));
		Object[][] data = new Object[rows-1][cols];
		
		
		/*data[0][0] = excel.getCellData(sheetName, 0, 2);
		data[0][1] = excel.getCellData(sheetName, 1, 2);

		data[1][0] = excel.getCellData(sheetName, 0, 3);
		data[1][1] = excel.getCellData(sheetName, 1, 3); */
		
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
