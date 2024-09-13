package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReaddataFromExcel {
public static void main(String[] args) throws IOException {
	//Step1: get the Excel path location & Java Object of the Physical ExcelFile
	FileInputStream fis=new FileInputStream("E:\\data/TestScriptData.xlsx");
	//Step2:Open Workbook in readmode
	Workbook wb = WorkbookFactory.create(fis);
	//Step3: get the control of the "org" sheet
	Sheet sheet = wb.getSheet("org");
	//Step4:get the control of the "1st" Row
	Row row = sheet.getRow(1);
	//Step 5:get the control of the "2nd"Cell & read the string data
	 double data = row.getCell(3).getNumericCellValue();
	System.out.println(data);
	//Step 6: Close the WorkBook
	wb.close();
}
}
