package api.utility;

import java.io.IOException;

import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "Data")
	public String[][] getAllData() throws IOException {

		String path = System.getProperty("user.dir") + "//userdata.xlsx";
		XLUtility xl = new XLUtility(path);

		int rownum = x1.getRowCount("Sheet1");
		int colcount = x1.getCellCount("Sheet1", 1);

		String apidata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				apidata[i - 1][1] = x1.getCellData("Sheet1", i, j);
			}
		}
		return apidata;

	}

	@DataProvider (name="UserNames") 
	public String[] getUserNames() throws IOException
	{ 
		String path=System.getProperty("user.dir")+"//userdata.xlsx"; XLUtility xl=new XLUtility (path);

	int rownum=x1.getRowCount("Sheet1");

	String apidata[]=new String[rownum];

	for (int i=1;i<=rownum; i++) 
	{
		apidata[i-1]=x1.getCellData("Sheet1", i, j);

	}

	return apidata;
	}
}