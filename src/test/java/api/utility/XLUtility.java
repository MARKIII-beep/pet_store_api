package api.utility;
/*
 * Project Name: mainspring DEFECT module
 * Class Name: ExcelUtilities
 * Author Name: QEA21QE008 Group-4
 * Date: 24-05-2021
 * Description: This class is used for Reading and Writing data from/to Excel
*/
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {

	static String cellData;
	
    //Method used for fetching datas from excel
	public static String readFromExcel(String sheetName, String columnName, int row) {

		try {

			FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\datatables\\TestData.xlsx");
			XSSFWorkbook workbook= new XSSFWorkbook(file);
			XSSFSheet sheet= workbook.getSheet(sheetName);

			for(int i=0; i<=15; i++) {

				String getColumn= String.valueOf(sheet.getRow(0).getCell(i));

				if(getColumn.equalsIgnoreCase(columnName)) {

					cellData= String.valueOf(sheet.getRow(row).getCell(i));
					break;
				}
			}
			workbook.close();
		} 

		catch (Exception e) {

			System.out.println(e.getMessage());
		}

		return cellData;
	}

    //Method used for writing data into Excel
	public static void write(int row,int column,String msg)
	{
		try
		{
			FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\Output\\Test Case Status Report.xlsx");
			XSSFWorkbook workbook=new XSSFWorkbook(file);
			XSSFSheet sheet=workbook.getSheet("Status Report");
			if(sheet.getRow(row).getCell(column).getStringCellValue().equalsIgnoreCase("PASS")||sheet.getRow(row).getCell(column).getStringCellValue().equalsIgnoreCase("FAIL"))
			{
				if(msg.equalsIgnoreCase("Pass"))
				{
					sheet.getRow(row).getCell(column).setCellValue("PASS");
				}
				else if (msg.equalsIgnoreCase("Fail"))
				{
					sheet.getRow(row).getCell(column).setCellValue("FAIL");
				}
				else {

					sheet.getRow(row).getCell(column).setCellValue("FAIL");
				}
			}
			FileOutputStream output_file=new FileOutputStream(System.getProperty("user.dir")+"\\Output\\Test Case Status Report.xlsx");
			workbook.write(output_file);
			output_file.close();
			workbook.close();
		}
		catch(Exception e)
		{

			System.out.println(e.getMessage());
		}
	}

}
