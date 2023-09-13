package api.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.*;

public class ReadExcelFile {

	public static FileInputStream inputStream;

	public static XSSFWorkbook workbook;
	public static XSSFSheet excelsheet;
	public static XSSFRow row;

	public static XSSFCell cell;
	public static Logger log;

	public static String GetCellValue(String fileName, String sheetName, int rowNo, int cellno) {

		try {

			inputStream = new FileInputStream(fileName);
			System.out.println("Reading file" + fileName); // --\Cucumber_practice\Testrestassured\TestData\TestData.xlsx

			workbook = new XSSFWorkbook(inputStream);
			excelsheet = workbook.getSheet(sheetName);

		//	System.out.println(excelsheet);
			cell = workbook.getSheet(sheetName).getRow(rowNo).getCell(cellno);
			workbook.close();
			return cell.getStringCellValue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}

	}

	
	
	
	public static int getRowCount (String fileName, String sheetName)
	{

		try

		{

			inputStream = new FileInputStream(fileName);
			//create XSSFWorkBook Class object for excel file manipulation);
			
			System.out.println(fileName);
			workbook = new XSSFWorkbook(inputStream);
			excelsheet =  workbook.getSheet(sheetName);
			System.out.println("excelsheet name"+excelsheet);

			//get total no. of rows
			int ttlRows = excelsheet.getLastRowNum() +1;
			System.out.println("total rowscount in excel"+ttlRows);

			workbook.close();

			return ttlRows;

		}

		catch (Exception e)

		{
			return 0;

		}

	}
		

	public static int getRoColcount(String filename, String sheetname) {

		try {
			inputStream = new FileInputStream(filename);
			workbook = new XSSFWorkbook(inputStream);
			excelsheet = workbook.getSheet(sheetname);
			int ttlcolumns = excelsheet.getRow(0).getLastCellNum();
			workbook.close();
			return ttlcolumns;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}

	}

}
