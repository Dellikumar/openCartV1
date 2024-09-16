package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviders extends ExcelUtility {

	//DataProvider 1
	
	@DataProvider(name="ExcelData")
	public Object[][] exceldataProvide() throws IOException
	{
		 Object[][] arrobj=getCellData("C:\\Users\\Chand\\eclipse-workspace\\openCartV1\\testData\\Opencart_LoginData.xlsx","Sheet1");
		return arrobj;
	}
	
	
	
	
	
	//DataProvider 2
	
	//DataProvider 3
	
	//DataProvider 4
}

